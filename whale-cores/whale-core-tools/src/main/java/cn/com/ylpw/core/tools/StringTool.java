/**
 * <p>Title: StringTool.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月9日 上午9:11:51
 */
package cn.com.ylpw.core.tools;

import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Title: StringTool.java</p>
 * <p>Description: </p>
 * @author 张嘉杰
 * @date 2017年2月9日 上午9:11:51
 */
public class StringTool {
	
	/**
	 * 返回以0作前缀的指定长度的序列号
	 */
	public static String fixLength(String value, int fixLen) {
		return fixLength(value, fixLen, '0');
	}

	/**
	 * 返回指定名称和长度以及指定前缀的序列号，通常使用0作前缀
	 */
	public static String fixLength(String value, int fixLen, char fixChar) {
		return repeat(fixChar, fixLen - value.length()).concat(value);
	}
	
	private static String repeat(char ch, int repeat) {
		if (repeat < 1)
			return "";
		char[] buf = new char[repeat];
		for (int i = 0; i < repeat; i++) {
			buf[i] = ch;
		}
		return new String(buf);
	}
	
	/**
	 * 转化Map参数为拼接字符串 如：a=1&b=2
	 * @param map Map对象
	 * @return 符合规则的拼接字符串
	 */
	public static String map2String(Map<String, String> map) {
		if (null == map || map.isEmpty()) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (sb.length() > 0) {
				sb.append("&");
			}
			sb.append(entry.getKey()).append("=").append(entry.getValue());
		}
		
		return sb.toString();
	}
	
	/**
	 * 利用MD5进行加密,采用JDK自带的MD5算法 返回一个经过MD5加密后的32位的信息摘要
	 * @param str 需要Md5的字符串
	 * @return 符合规则的加密串
	 */
	public static String encoderByMd5(String str) {
		try {
			MessageDigest messageDigest = null;
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
			byte[] byteArray = messageDigest.digest();
			StringBuffer md5StrBuff = new StringBuffer();
			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
					md5StrBuff.append("0").append(
							Integer.toHexString(0xFF & byteArray[i]));
				} else {
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
				}
			}
			return md5StrBuff.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("参数有误，无法处理");
		}
	}
	
	/**
     * 判断字符串是否为null或""
     * @param s 字符串
     * @return 若为null或""返回true，反之false
     */
    public static Boolean isNullOrEmpty(String s){
        return s == null || "".equals(s);
    }
	
	public static void main(String[] args) {
		System.out.println(fixLength("abc",10));
		
		Map<String, String> map = new TreeMap<>();
		map.put("aaa", "1");
		map.put("bbb", "2");
		System.out.println(map2String(map));
		System.out.println(encoderByMd5(map2String(map)));
	}
}
