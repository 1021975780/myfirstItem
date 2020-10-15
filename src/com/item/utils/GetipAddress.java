package com.item.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
/**
 * 获得请求的ip地址
 * @author wangqun
 *
 */
public class GetipAddress {
	 public static String getIPAddress(HttpServletRequest request)
	    {
	        String ip = request.getHeader( "x-forwarded-for" );
	        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
	        {
	            ip = request.getHeader( "Proxy-Client-IP" );
	        }
	        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
	        {
	            ip = request.getHeader( "WL-Proxy-Client-IP" );
	        }
	        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
	        {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	    }
	 /**
	  * 获得当前日期
	  * @return
	  */
	 public static String getDate() {
		 Date date = new Date();
		 Locale locale = Locale.CHINA;
		 DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
		 String now_date = dateFormat.format(date);
		 return now_date;
	 }
}
