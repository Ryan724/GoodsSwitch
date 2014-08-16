package com.goodsswitch.tool;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * 
 * @author zhangby5
 * 
 */
public class DateUtils {

	/**
	 * 获取当前日期(日期时分秒)
	 * @return
	 */
	public static String getTime(){
		DateFormat df=DateFormat.getDateTimeInstance(DateFormat.DEFAULT,DateFormat.DEFAULT,Locale.CHINA);
		return df.format(new Date());
	}
	
	/**
	 * 获取当前日期(中国时间格式例如:2014年5月18日 星期日 下午02时33分27秒 CST)
	 * @return
	 */
	public static String getChinaTime(){
		DateFormat df=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.CHINA);
		return df.format(new Date());
	}
	
	/**
	 * 获取当前日期(日期时分秒毫秒)
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		Timestamp time = new Timestamp(new Date().getTime());
		return time.toString();
	}

	/**
	 * 获取当前日期(日期)
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
		return matter.format(date);
	}

	/**
	 * 当前日期的下一天
	 * 
	 * @return
	 */
	public static String getNextDate() {
		Date date = new Date();
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
		long time = (date.getTime() / 1000) + 60 * 60 * 24;
		date.setTime(time * 1000);
		String nextDate = matter.format(date).toString();
		return nextDate;
	}

}
