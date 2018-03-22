package com.lmw.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * <p> Description:  </p>
 * @Author JiaChunYan
 * @Date [2016-1-13] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号   修改人  修改时间     修改内容描述
 * ----------------------------------------
 * V1.0		贾春燕	2016-1-13	新建文件.
 * 
 * </pre>
 */
public class DateTimeFormat {

	public static String getDateBillFormat(Date date,String format) {
		if (date == null) {
			return "";
		}
		if(null == format || "".equals(format)){
			format = "yyyyMMdd";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		return sdf.format(date);
	}
	
	public static String getDateBillFormat(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static String getDateString(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		return sdf.format(date);
	}

	public static Date getDateFromString(String format, String str) {
		Date date = null;
		if(null==str){
			return null;
		}
		SimpleDateFormat format1 = new SimpleDateFormat(format);
		try {
			date = format1.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 给日期添加天数
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}
	public static int compareDate(Date date1,Date date2){
		if(null==date1 || null==date2){
			return 0;
		}
		String d1=DateTimeFormat.getDateString(date1, "yyyyMMdd");
		String d2=DateTimeFormat.getDateString(date2, "yyyyMMdd");
		int v1=Integer.parseInt(d1);
		int v2=Integer.parseInt(d2);
		if(v1==v2){
			return 0;
		}else if(v1<v2){
			return -1;
		}else{
			return 1;
		}
	}
	public static int compareMonthDate(Date date1,Date date2){
		if(null==date1 || null==date2){
			return 0;
		}
		
		String d1=DateTimeFormat.getDateString(date1, "yyyyMMdd");
		String d2=DateTimeFormat.getDateString(date2, "yyyyMMdd");
		d1=d1.substring(4, d1.length());
		d2=d2.substring(4, d2.length());
		int v1=Integer.parseInt(d1);
		int v2=Integer.parseInt(d2);
		if(v1==v2){
			return 0;
		}else if(v1<v2){
			return -1;
		}else{
			return 1;
		}
	}
	public static int getDaySub(Date dateBegin,Date dateEnd){
        int day=0;
        if(null==dateBegin || null==dateEnd){
        	return day;
        }
        try{
            Long lday=(dateEnd.getTime()-dateBegin.getTime())/(24*60*60*1000);    
            //System.out.println("相隔的天数="+day);   
            day=lday.intValue();
        } catch (Exception e){
            e.printStackTrace();
        }   
        return day;
    }
	public static Date stringToDate(String dateString) throws Exception{
		String strFormat = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
//	    System.out.print(new java.sql.Date(sdf.parse(dateString).getTime()));
		if(dateString == null || dateString.replace(" ", "").length() == 0){//防止有空格,不能这样判断：dateString.replace(" ", "") == ""
			return null;
		}else{
			return new java.sql.Date(sdf.parse(dateString).getTime());
//			return null;
		}
 	}
	// 日期格式为""空时转换
	public static Date nullToDate(Date date,String type) throws Exception{
		Date returnDate = date;
		if(type == "start"){
			if(returnDate == null){
				returnDate = stringToDate("1970-01-01");
			}
		}else if(type == "end"){
			if(returnDate == null){
				returnDate = stringToDate("9999-12-31");
			}
		}
		return returnDate;
	}
}
