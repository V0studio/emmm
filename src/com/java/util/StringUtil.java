package com.java.util;
/**
 * 字符串工具类
 * @author 四侠卑鄙
 *
 */
public class StringUtil {
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
