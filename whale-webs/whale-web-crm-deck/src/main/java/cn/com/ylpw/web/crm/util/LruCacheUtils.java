package cn.com.ylpw.web.crm.util;

import java.lang.reflect.Array;
import java.util.Iterator;


/**
 * LRU -- 最近最少使用算法 <br>
 * Fixed length cache with a LRU replacement policy. If cache items implement
 * CacheNotifyObject, they will be informed when they're removed from the cache.
 * <p>
 * Null keys are not allowed. LruCache is synchronized. <br>
 * 用法:<br>
 * <pre>
 * LruCache<String> cache = new LruCache<String>();
 * cache.setDefaultCacheLiveTime(3600000); // 默认的缓存有效时间为一小时
 * cache.put("1","a",60000L);  // 这一项的缓存时间为60秒
 * cache.put("2","b");  // 使用默认的缓存时间进行缓存
 * String data = cache.get("1");<br>
 *  </pre>
 */
public class LruCacheUtils<V> {
	// hash table containing the entries. Its size is twice the capacity
	// so it will always remain at least half empty
	private CacheItem[] entries;

	// maximum allowed entries
	private int capacity;

	// number of items in the cache
	private int size;

	private int mask;

	// head of the LRU list
	private CacheItem head;

	// tail of the LRU list
	private CacheItem tail;

	private long defaultCacheLiveTime = 0; // Object cache limit time,=0 is no
	// time

	// limit

	private static Long NULL = new Long(0);

	private static long MIN_CACHE_WARN_TIME = 1000;

	/**
	 * Create the LRU cache with a specific capacity.
	 * 
	 * @param initialCapacity minimum capacity of the cache
	 */
	public LruCacheUtils(int initialCapacity) {
		int capacity;

		for (capacity = 16; capacity < 2 * initialCapacity; capacity *= 2) {
		}

		entries = (CacheItem[]) Array.newInstance(CacheItem.class, capacity);
		mask = capacity - 1;

		this.capacity = initialCapacity;
	}

	public LruCacheUtils(int initialCapacity, long defaultCacheLiveTime) {
		this(initialCapacity);
		this.defaultCacheLiveTime = defaultCacheLiveTime;
	}

	/**
	 * Returns the current number of entries in the cache.
	 */
	public int size() {
		return size;
	}

	/**
	 * Clears the cache
	 */
	public void clear() {
		synchronized (this) {
			for (int i = 0; i < entries.length; i++) {
				entries[i] = null;
			}

			size = 0;
			head = null;
			tail = null;
		}

	}

	public Object getSynchronizedObject() {
		return this;
	}

	/**
	 * Get an item from the cache and make it most recently used.
	 * 
	 * @param key key to lookup the item
	 * @return the matching object in the cache
	 */
	public V get(Object key) {
		return get(key, 0);
	}

	private V get(Object key, long skip) {
		if (key == null)
			key = NULL;

		int hash = key.hashCode() & mask;
		int count = size + 1;
		boolean outdate = false;

		synchronized (this) {
			for (; count > 0; count--) {
				CacheItem item = entries[hash];

				if (item == null)
					return null;

				/**
				 * 得到每一个缓存项的生存时间(毫秒)
				 */
				long skipTime = item.cacheLiveTime;

				if (item.key == key || item.key.equals(key)) {
					long currentTimeMillis = System.currentTimeMillis();
					if (skipTime > 0
							&& currentTimeMillis - item.cacheTime > skipTime) {
						outdate = true;
						break;
					}
					/**
					 * 只更新前后顺序,不需要更新缓存时间
					 */
					updateLru(item);
					return item.value;
				}

				hash = (hash + 1) & mask;
			}
		}

		if (outdate)
			remove(key);

		return null;
	}

	/**
	 * Puts a new item in the cache. If the cache is full, remove the LRU item.
	 * 
	 * @param key key to store data
	 * @param value value to be stored
	 * @return old value stored under the key
	 */
	public V put(Object key, V value) {
		return localPut(key, value);
	}

	public V put(Object key, V value, long cacheLiveTime) {
		return localPut(key, value, cacheLiveTime);
	}

	public V localPut(Object key, V value) {
		return localPut(key, value, defaultCacheLiveTime);
	}

	public V localPut(Object key, V value, long itemCacheLiveTime) {
		if (key == null)
			key = NULL;

		// remove LRU items until we're below capacity
		while (size >= capacity) {
			remove(tail.key, true);
		}

		V oldValue = null;

		int hash = key.hashCode() & mask;
		int count = size + 1;

		synchronized (this) {
			for (; count > 0; count--) {
				CacheItem item = entries[hash];

				// No matching item, so create one
				if (item == null) {
					item = new CacheItem(key, value,itemCacheLiveTime);
					entries[hash] = item;
					size++;
					item.next = head;
					if (head != null) {
						head.prev = item;
					} else {
						tail = item;
					}
					head = item;
					return null;
				}

				// matching item gets replaced
				if (item.key == key || item.key.equals(key)) {
					updateLru(item);

					oldValue = item.value;
					item.value = value;
					item.cacheTime = System.currentTimeMillis();
					item.cacheLiveTime = itemCacheLiveTime;
					break;
				}

				hash = (hash + 1) & mask;
			}
		}

		return oldValue;
	}

	/**
	 * Put item at the head of the lru list. This is always called while
	 * synchronized.
	 */
	private void updateLru(CacheItem item) {
		CacheItem prev = item.prev;
		CacheItem next = item.next;

		if (prev != null) {
			prev.next = next;

			item.prev = null;
			item.next = head;
			head.prev = item;
			head = item;

			if (next != null) {
				next.prev = prev;
			} else {
				tail = prev;
			}
		}
	}

	/**
	 * Remove the last item in the LRU
	 */
	public boolean removeTail() {
		CacheItem last = tail;

		if (last == null) {
			return false;
		} else {
			remove(last.key);
			return true;
		}
	}

	public V remove(Object key) {
		return remove(key, false);
	}

	/**
	 * Removes an item from the cache
	 * 
	 * @param key the key to remove
	 * @return the value removed
	 */
	public V remove(Object key, boolean bNotify) {
		if (key == null)
			key = NULL;

		int hash = key.hashCode() & mask;
		int count = size + 1;

		V value = null;

		synchronized (this) {
			for (; count > 0; count--) {
				CacheItem item = entries[hash];

				if (item == null)
					return null;

				if (item.key == key || item.key.equals(key)) {

					if (bNotify
							&& System.currentTimeMillis() - item.cacheTime < MIN_CACHE_WARN_TIME) {
						System.err
								.println("cache item less min cache time - "
										+ item.value.getClass().toString()
										+ ","
										+ ((System.currentTimeMillis() - item.cacheTime) / 1000));
					}

					entries[hash] = null;
					size--;

					CacheItem prev = item.prev;
					CacheItem next = item.next;

					if (prev != null) {
						prev.next = next;
					} else {
						head = next;
					}

					if (next != null) {
						next.prev = prev;
					} else {
						tail = prev;
					}

					// Shift colliding entries down
					for (int i = 1; i <= count; i++) {
						int nextHash = (hash + i) & mask;
						CacheItem nextItem = entries[nextHash];
						if (nextItem == null)
							break;

						entries[nextHash] = null;
						refillEntry(nextItem);
					}

					value = item.value;
					break;
				}

				hash = (hash + 1) & mask;
			}
		}

		if (count < 0)
			throw new RuntimeException("internal cache error");

		return value;
	}

	/**
	 * Put the item in the best location available in the hash table.
	 */
	private void refillEntry(CacheItem item) {
		int baseHash = item.key.hashCode();

		for (int count = 0; count < size + 1; count++) {
			int hash = (baseHash + count) & mask;

			if (entries[hash] == null) {
				entries[hash] = item;
				return;
			}
		}
	}

	/**
	 * Returns the keys stored in the cache
	 */
	public Iterator<Object> keys() {
		KeyIterator iter = new KeyIterator();
		iter.init(this);
		return iter;
	}

	/**
	 * Returns keys stored in the cache using an old iterator
	 */
	public Iterator<Object> keys(Iterator oldIter) {
		KeyIterator iter = (KeyIterator) oldIter;
		iter.init(this);
		return iter;
	}

	/**
	 * Returns the values in the cache
	 */
	public Iterator<V> values() {
		ValueIterator iter = new ValueIterator();
		iter.init(this);
		return iter;
	}

	public Iterator<V> values(Iterator oldIter) {
		ValueIterator iter = (ValueIterator) oldIter;
		iter.init(this);
		return iter;
	}

	public long getDefaultCacheLiveTime() {
		return defaultCacheLiveTime;
	}

	public void setDefaultCacheLiveTime(long cacheLiveTime) {
		this.defaultCacheLiveTime = cacheLiveTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void removeValue(Object value) {
		for (int i = 0; i < entries.length; i++) {
			CacheItem item = entries[i];
			if (item != null) {
				if (item.value == value) {
					remove(item.key);
					return;
				}
			}
		}
	}

	/**
	 * A cache item
	 */
	private class CacheItem {
		CacheItem prev;

		CacheItem next;

		Object key;

		V value;

		int index;

		long cacheTime;

		/**
		 * 每一项的生存时间
		 */
		long cacheLiveTime = 0;

		@Deprecated
		public CacheItem(Object key, V value) {
			this(key, value, 0);
		}

		public CacheItem(Object key, V value, long cacheLiveTime) {
			this.key = key;
			this.value = value;
			cacheTime = System.currentTimeMillis();
			this.cacheLiveTime = cacheLiveTime;
		}

	}

	/**
	 * Iterator of cache keys
	 */
	private class KeyIterator implements Iterator<Object> {
		CacheItem item;

		void init(LruCacheUtils<V> cache) {
			item = cache.head;
		}

		public boolean hasNext() {
			return item != null;
		}

		public Object next() {
			Object value = item.key;
			item = item.next;
			return value;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Iterator of cache values
	 */
	private class ValueIterator implements Iterator<V> {

		CacheItem item;

		void init(LruCacheUtils<V> cache) {
			item = cache.head;
		}

		public boolean hasNext() {
			return item != null;
		}

		public V next() {
			V value = item.value;
			item = item.next;
			return value;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
