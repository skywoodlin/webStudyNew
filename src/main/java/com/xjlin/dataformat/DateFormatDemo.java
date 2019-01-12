package com.xjlin.dataformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateFormatDemo {
	/**
	 * 将日期对象转换为字符串表示形式,此时根据地区语言环境不同,需要转成不同样式的字符串形式
	 */
	@Test
	public void test1(){
		Date date = new Date();
//		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.KOREA);
		String dateStr = format.format(date);
		System.out.println(dateStr);
	}
	
	/**
	 * 将字符串形式的日期时间信息转换为Date对象
	 * @throws ParseException 
	 */
	@Test
	public void test2() throws ParseException{
		String dateStr = "2014年1月24日 星期五 上午11时56分39秒 CST";
		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
		Date date = format.parse(dateStr);
		System.out.println(date.toLocaleString());
	}
	
	/**
	 * 9月~~10日##2013年**12时%20分%10秒
	 * @throws ParseException 
	 */
	@Test
	public void test3() throws ParseException{
		String dateStr = "09月~~10日##2013年**12时%20分%10秒";
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM月~~dd日##yyyy年**HH时%mm分%ss秒");
		Date date = dateFormat.parse(dateStr);
		System.out.println(date.toLocaleString());
	}
	
	@Test
	public void test4(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM月~~dd日##yyyy年**HH时%mm分%ss秒");
		String str = dateFormat.format(date);
		System.out.println(str);
	}
}
