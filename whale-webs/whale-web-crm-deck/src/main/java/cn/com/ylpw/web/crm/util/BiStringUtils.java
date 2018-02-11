package cn.com.ylpw.web.crm.util;

public class BiStringUtils {
  
  public static Iterable<String> splitter(String strs) {
    return splitter(strs, ",");
  }
  
  public static Iterable<String> splitter(String strs, String split) {
    if(null == strs) return null;
    return com.google.common.base.Splitter.on(split).trimResults().omitEmptyStrings().split(strs);
  }
  
  public static void main(String[] args){
    System.out.println(BiStringUtils.splitter(null));
  }

}
