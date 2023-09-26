package com.java.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间工具类
 * @author
 *
 */
public class DateTimeUtil {
	/**
	 * 判断是否为日期
	 * @param s
	 * @return
	 */
	public static boolean isDate(String s) {
		return isLegalDate(s.length(),s,"yyyy-MM-dd");
	}
	/**
	 * 判断是否为时间
	 * @param s
	 * @return
	 */
	public static boolean isTime(String s) {
		return isLegalDate(s.length(),s,"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 判断是否为日期时间
	 * @param s
	 * @return
	 */
	public static boolean isDateTime(String s) {
		return isLegalDate(s.length(),s,"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 根据时间和时间格式校验是否正确
	 * @param length
	 * @param sDate
	 * @param format
	 * @return
	 */
	public static boolean isLegalDate(int length,String sDate,String format) {
		int legalLen = length;
		if((sDate==null)||(sDate.length()!=legalLen)) {
			return false;
		}
		DateFormat formatter = new SimpleDateFormat(format);
		try {
			Date date=formatter.parse(sDate);
			return sDate.equals(formatter.format(date));
		}catch(Exception e) {
			return false;
		}
	}
	
	public static Date StringDate(String s)throws ParseException{
		DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		Date date=fmt.parse(s);
		return date;
	}
	
	public static Date StringTime(String s)throws ParseException{
		DateFormat fmt=new SimpleDateFormat("HH:mm:ss");
		Date time=fmt.parse(s);
		return time;
	}
	
	public static Date StringDateTime(String s)throws ParseException{
		DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datetime=fmt.parse(s);
		return datetime;
	}

	public static String DateToString()throws ParseException{
		Date date = new Date();
		DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = fmt.format(date);
		return format;
	}
}
