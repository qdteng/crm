package cn.com.ylpw.web.crm.util;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 与IP相关的工具方法
 *
 * @author ZhaoHb
 * @since 0.1.0
 */
public class IPUtils {

  private IPUtils() {}
  
  public static final String HEADER_X_FORWARDED_FOR = "x-forwarded-for";
  
  private static final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
  public static final Pattern IP_PATTERN = 
      Pattern.compile("^(?:" + _255 + "\\.){3}" + _255 + "$");
  
  public static final long PRIVATE_IP_10_0_0_0 = ipV4ToLong("10.0.0.0");
  public static final long PRIVATE_IP_10_255_255_255 = ipV4ToLong("10.255.255.255");
  public static final long PRIVATE_IP_172_16_0_0 = ipV4ToLong("172.16.0.0");
  public static final long PRIVATE_IP_172_31_255_255 = ipV4ToLong("172.31.255.255");
  public static final long PRIVATE_IP_192_168_0_0 = ipV4ToLong("192.168.0.0");
  public static final long PRIVATE_IP_192_168_255_255 = ipV4ToLong("192.168.255.255");
  
  /**
   * 将以长整型表示的IPv4地址转换为字符串形式
   * 
   * @param longIp  长整型表示IPv4地址
   * @return        字符串形式的IPv4地址
   */
  public static String longToIpV4(long intIp) {
    int octet3 = (int) ((intIp >> 24) % 256);
    int octet2 = (int) ((intIp >> 16) % 256);
    int octet1 = (int) ((intIp >> 8) % 256);
    int octet0 = (int) ((intIp) % 256);
    return octet3 + "." + octet2 + "." + octet1 + "." + octet0;
  }
  
  /**
   * 将字符串形式的IPv4地址转换为长整型
   * 
   * @param ip      字符串形式的IPv4地址
   * @return        长整型表示的IPv4地址
   */
  public static long ipV4ToLong(String ip) {
    String[] octets = ip.split("\\.");
    return (Long.parseLong(octets[0]) << 24) + (Long.parseLong(octets[1]) << 16) +
        (Long.parseLong(octets[2]) << 8) + Long.parseLong(octets[3]);
  }
  
  /**
   * 判断IPv4地址是否是内网地址
   * 
   * @param ip  字符串形式的IPv4地址
   * @return    true or false
   */
  public static boolean isIPv4Private(String ip) {
    long intIp = ipV4ToLong(ip);
    return 
        (intIp >= PRIVATE_IP_10_0_0_0 && intIp <= PRIVATE_IP_10_255_255_255) ||
        (intIp >= PRIVATE_IP_172_16_0_0 && intIp <= PRIVATE_IP_172_31_255_255) ||
        (intIp >= PRIVATE_IP_192_168_0_0 && intIp <= PRIVATE_IP_192_168_255_255);
  }
  
  /**
   * 判断是否是有效的IPv4地址地址
   * 
   * @param ip
   * @return
   */
  public static boolean isIPv4Valid(String ip) {
    return IP_PATTERN.matcher(ip).matches();
  }
  
  /**
   * <p>返回真实IPv4地址。
   * 
   * <p>如果服务器使用了反向代理，则应该会将客户端真实IP地址存放在某个请求头中，
   * 多层反向代理会在该请求头中逐个添加自身的IP地址。解析该请求头以获取真实IP地址。
   * 
   * <p>若未设置反向代理请求头的名字，则默认使用{@link #HEADER_X_FORWARDED_FOR}。
   * 
   * @param request                 客户端请求对象
   * @param forwardedHeaderName     目标请求头的名字
   * @return                        IPv4地址
   */
  public static String fetchRealIPv4Addr(HttpServletRequest request, 
      String forwardedHeaderName) {
    String ip = null;
    boolean found = false;
    
    if (forwardedHeaderName == null) {
      forwardedHeaderName = HEADER_X_FORWARDED_FOR;
    }
    
    if ((ip = request.getHeader(forwardedHeaderName)) != null) {
      String[] ips = ip.split(",", -1);
      for (String ipInHeader: ips) {
        if (isIPv4Valid(ipInHeader) && !isIPv4Private(ipInHeader)) {
          found = true;
          return ipInHeader;
        }
      }
    }

    if (!found) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }
  
  /**
   * <p>返回真实IPv4地址。
   * 
   * <p>如果服务器使用了反向代理，则应该会将客户端真实IP地址存放在某个请求头中，
   * 多层反向代理会在该请求头中逐个添加自身的IP地址。解析该请求头以获取真实IP地址。
   * 默认解析请求头{@link #HEADER_X_FORWARDED_FOR}来获取IP地址。
   * 
   * <p>若反向代理服务器使用的是其他请求头，
   * 则可以使用{@link #fetchRealIPv4Addr(HttpServletRequest, String)}方法，
   * 显式指定请求头的名字。
   * 
   * @param request                 客户端请求对象
   * @return                        IPv4地址
   */
  public static String fetchRealIPv4Addr(HttpServletRequest request) {
    return fetchRealIPv4Addr(request, HEADER_X_FORWARDED_FOR);
  }
  
}
