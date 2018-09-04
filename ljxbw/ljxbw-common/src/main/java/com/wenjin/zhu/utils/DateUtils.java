package com.wenjin.zhu.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * @Title: DateUtils.java
 * @Package com.wenjin.zhu.utils
 * @Description: (日期时间处理)
 * @author: wenjin.zhu
 * @date: 2018年8月22日 下午4:12:53
 * @version V1.0
 */
public class DateUtils {

	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 获取指定时间的毫秒值
	 */
	public static long getDatelongMills(String pattern, String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long longDate = date.getTime();
		return longDate;
	}

	public static void main(String[] args) {
		System.out.println(format(new Date()));
		System.out.println(format(new Date(), DATE_TIME_PATTERN));
		System.out.println(getDatelongMills(DATE_TIME_PATTERN, "2018-09-09 12:12:12"));
		long t1 = getDatelongMills(DATE_TIME_PATTERN, "2018-08-23 12:57:12");
		long t2 = getDatelongMills(DATE_TIME_PATTERN, format(new Date(), DATE_TIME_PATTERN));
		Date d1 = new Date(t1);
		Date d2 = new Date(t2);
		System.out.println("相差" + m2(Math.abs((double) (d1.getTime() - d2.getTime()) / 1000 / 60 / 60)) + "个小时");

	}

	public static String m2(double arg0) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(arg0);
	}
}
