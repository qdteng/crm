/**
 * <p>Title: DateTool.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年1月22日 下午4:01:16
 */
package cn.com.ylpw.core.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: DateTool.java</p>
 * <p>Description: </p>
 * @author 张嘉杰
 * @date 2017年1月22日 下午4:01:16
 */
@SuppressWarnings("unused")
public class DateTool extends org.apache.commons.lang3.time.DateUtils {
	
	private DateTool() { }
	
	// 单例模式
    private static DateTool instance;
	private static DateTool getInstance(){
        if(instance == null){
            instance = new DateTool();
        }
        return instance;
    }
	
	/** 日期格式:yyyy-MM-dd */
    public static final String YMD = "yyyy-MM-dd";

    /** 日期格式:yyyy-MM-dd HH:mm:ss */
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /** 时间格式:HH:mm:ss */
    public static final String HMS = "HH:mm:ss";

    /** 日期格式:yyyy-MM-dd HH:mm:ss SSS */
    public static final String YMDHMSS = "yyyy-MM-dd HH:mm:ss SSS";

    /** 短日期格式:yyyy-M-d */
    public static final String SHORT_YMD = "yyyy-M-d";

    /** 短日期格式:yyyy-M-d H:m:s */
    public static final String SHORT_YMDHMS = "yyyy-M-d H:m:s";

    /** 短日期格式:yyyy-M-d H:m:s S */
    public static final String SHORT_YMDHMSS = "yyyy-M-d H:m:s S";

    /** 中文日期格式:yyyy年MM月dd日 */
    public static final String CN_YMD = "yyyy年MM月dd日";

    /** 中文日期格式:HH时mm分ss秒 */
    public static final String CN_HMS = "HH时mm分ss秒";

    /** 中文日期格式:yyyy年MM月dd日 HH时mm分ss秒 */
    public static final String CN_YMDHMS = "yyyy年MM月dd日HH时mm分ss秒";

    /** 中文日期格式:yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒 */
    public static final String CN_YMDHMSS = "yyyy年MM月dd日HH时mm分ss秒SSS毫秒";

    /** 中文短日期格式:yyyy年M月d日 */
    public static final String CN_SHORT_YMD = "yyyy年M月d日";

    /** 中文短日期格式:yyyy年M月d日 H时m分s秒 */
    public static final String CN_SHORT_YMDHMS = "yyyy年M月d日H时m分s秒";

    /** 中文短日期格式:yyyy年M月d日 H时m分s秒 S毫秒 */
    public static final String CN_SHORT_YMDHMSS = "yyyy年M月d日H时m分s秒S毫秒";


    /**
     * <p>格式化日期</p>
     * <p>G 年代标志符</p>
     * <p>y年  M月  d日  h时(1~12)  H时(0~23)  m分  s秒  S毫秒</p>
     * <p>E 星期</p>
     * <p>D一年中的第几天  F一月中第几个星期几  w一年中第几个星期  W 一月中第几个星期</p>
     * <p>a 上午 / 下午 标记符</p>
     * <p>k 时 在一天中 (1~24)  K 时 在上午或下午 (0~11)</p>
     * <p>z 时区</p>
     *
     * @see java.text.SimpleDateFormat
     * @param date 日期
     * @param formatStr 日期的格式，参考SimpleDateFormat
     * @return String 字符串的日期格式
     */
    public static final String dateFormat(Date date, String formatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        String dStr = formatter.format(date);
        return dStr;
    }
    
    /**
     * <p>取得日期yyyy-MM-dd HH:mm:ss格式的字符串</p>
     * @param date 日期
     * @return 字符串的日期格式(yyyy-MM-dd HH:mm:ss)
     */
    public static final String getDateTimeStr(Date date) {
        String dStr = dateFormat(date, YMDHMS);
        return dStr;
    }
	
    /**
     * <p>取得日期yyyy-MM-dd格式的字符串</p>
     * @param date 日期
     * @return 字符串的日期格式(yyyy-MM-dd)
     */
    public static final String getDateStr(Date date) {
        String dStr = dateFormat(date, YMD);
        return dStr;
    }
    
    /**
     * <p>取得时间HH:mm:ss格式的字符串</p>
     * @param date 日期
     * @return 字符串的时间格式(HH:mm:ss)
     */
    public static final String getTimeStr(Date date) {
        String dStr = dateFormat(date, HMS);
        return dStr;
    }

    /**
     * <p>取得日期yyyy年MM月dd日HH时mm分ss秒中文格式的字符串</p>
     * @param date 日期
     * @return 字符串的中文日期格式(yyyy年MM月dd日HH时mm分ss秒)
     */
    public static final String getCNDateTimeStr(Date date) {
        String dStr = dateFormat(date, CN_YMDHMS);
        return dStr;
    }

    /**
     * <p>取得日期yyyy年MM月dd日中文格式的字符串</p>
     * @param date 日期
     * @return 字符串的中文日期格式(yyyy年MM月dd日)
     */
    public static final String getCNDateStr(Date date) {
        String dStr = dateFormat(date, CN_YMD);
        return dStr;
    }

    /**
     * <p>取得日期HH时mm分ss秒中文格式的字符串</p>
     * @param date 日期
     * @return 字符串的中文日期格式(HH时mm分ss秒)
     */
    public static final String getCNTimeStr(Date date) {
        String dStr = dateFormat(date, CN_HMS);
        return dStr;
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
	
	
    
}
