package cn.com.ylpw.web.crm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;



public class DateUtils {
	
	public static String CURRENTTIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static String MMDD_FROMAT = "MM/dd";
	
	public static Date parseDate(String dateStr,String formatStr){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern(formatStr);
		try {
			return simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date parseDateLong(String dateStr){
		return parseDate(dateStr, CURRENTTIME_FORMAT);
	}
	
	public static String formatDate(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern(MMDD_FROMAT);
		return simpleDateFormat.format(date);
	}
	
	
	public static String[] getDateBetween(String begDate, String endDate)
	        throws Exception {
		Date  minDate = parseDate(begDate,"yyyy-MM-dd");
		Date  maxDate = parseDate(endDate,"yyyy-MM-dd");
	    if (minDate.compareTo(maxDate)>0)
	        throw new Exception("开始时间应该在结束时间之后");
	    Long spi = maxDate.getTime() - minDate.getTime();
	    Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数
	    List<Date> dateList = new ArrayList<Date>();
	    dateList.add(maxDate);
	    for (int i = 1; i <= step; i++) {
	    	Date tempDate = new Date(dateList.get(i - 1).getTime()- (24 * 60 * 60 * 1000));
	        dateList.add(tempDate);// 比上一天减一
	    }
	    Collections.reverse(dateList);
	    List<String> resultList = Lists.newArrayList();
	    for(Date d:dateList){
	    	resultList.add(formatDate(d));
	    }
	    String[] s = new String[resultList.size()];
	    return resultList.toArray(s);
	}
	
	public static String getLastDate(int offset){
		Calendar   calendar   =   Calendar.getInstance();
		calendar.add(Calendar.DATE,   offset);
		String LastDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		return LastDate;
	}

	public static String getFirstDateOfMonth(){
		Calendar calendar = Calendar.getInstance();    
		calendar.add(Calendar.MONTH, 0);
		//设置为1号,当前日期既为本月第一天 
		calendar.set(Calendar.DAY_OF_MONTH,1);
		String first = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		return first;
	}
	
	/**
	 * <p>Long 时间字符串转 date </p>
	 * @author LT
	 * @date 2017年4月25日 上午11:18:00
	 * @return String yyyy-MM-dd HH:mm:ss
	 * @param timeStr
	 * @return
	 
	 */
	public static String longToDateStr(Long timeStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date= new Date(timeStr);
		return sdf.format(date);
	}
	
	/**
	 * <p>Long 时间字符串转 date </p>
	 * @author LT
	 * @date 2017年4月25日 上午11:18:00
	 * @return String yyyy-MM-dd HH:mm:ss
	 * @param Date
	 * @return
	 */
	public static Date longToDate(Long timeStr){
		if(null==timeStr) return null; 
		Date date= new Date(timeStr);
		return date ;
	}
	
	
	public static void main(String[] args){
		 System.out.println(parseDateLong("1479431702000"));

	}
	
}
