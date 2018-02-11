package cn.com.ylpw.web.crm.util;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * redicache 工具类
 * 
 */
@SuppressWarnings("unchecked")
@Component("redisUtil")
public class RedisUtilBasic {

	/**
	 * 1分钟
	 */
	public static final long MINUTES_1 = 60;

	/**
	 * 1小时
	 */
	public static final long HOURS_1 = 60 * 60;

	/***
	 * 1天
	 */
	public static final long DAYS_1 = 60 * 60 * 24l;

	/***
	 * 1天
	 */
	public static final long KAFKA_SAVE_TIME_OUT = DAYS_1 * 7;

	private static final Logger log = LoggerFactory.getLogger(RedisUtilBasic.class);

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 批量删除对应的value
	 * 
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 * 
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}

	/**
	 * 删除对应的value
	 * 
	 * @param key
	 */
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object get(final String key) {
		Object result = null;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			result = operations.get(key);
		} catch (Exception e) {
			log.error("get redis key {}  is  error  ", key, e);

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			log.error("set redis key {} value {}  is  error  ", key, value, e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 *            (秒)
	 * @return
	 */
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			log.error("set redis key {}  value {}  is  error  ", key, value, e);
			e.printStackTrace();
		}
		return result;
	}

	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void rPushList(String key, Object value) {
		
		redisTemplate.opsForList().rightPush(key, value);
	}

	public Object lPopList(String key) {
		return redisTemplate.opsForList().leftPop(key);
	}
	
	public void sadd(String key, Object value) {
		redisTemplate.opsForSet().add(key, value);
	}
	
	public Long sremove(String key, Object value) {
		return redisTemplate.opsForSet().remove(key, value);
	}
	
	public Boolean isMember(String key, Object value) {
		return redisTemplate.opsForSet().isMember(key, value);
	}

}