package com.xlx.shiro.common.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author xielx on 2019/7/15
 */
public class DateUtil {


  private static final String FULL_TIME = "yyyy-MM-dd HH:mm:ss";
  private static final String YEAR ="yyyy";
  private static final String DATE = "yyyy-MM-dd";
  private static final String TIME = "HH:mm:ss";

  /**
   * 获取当前日期
   * @return date
   */
  public static Date getNowDate(){
    return new Date();
  }


  /**
   * 字符型日期
   * @param date Date
   * @return yyyy/MM/dd HH:mm:ss
   */
  public static String formatDateToFullTime(Date date){
    return new SimpleDateFormat(FULL_TIME).format(date);
  }

  /**
   * 字符日期-年月日
   * @param date Date
   * @return yyyy-MM-dd
   */
  public static String formatDateToDate(Date date){
    return new SimpleDateFormat(DATE).format(date);
  }

  /**
   * 字符日期-年份
   * @param date Date
   * @return yyyy
   */
  public static String formatDateToYear(Date date){
    return new SimpleDateFormat(YEAR).format(date);
  }

  /**
   * 字符日期-时分秒
   * @param date Date
   * @return HH:mm:ss
   */
  public static String formatDateToTime(Date date){
    return new SimpleDateFormat(TIME).format(date);
  }


  public static Date parseStringToFullTime(String text) throws ParseException {
    return new SimpleDateFormat(FULL_TIME).parse(text);
  }


  public static Date parseStringToYear(String text) throws ParseException {
    return new SimpleDateFormat(YEAR).parse(text);
  }

  public static Date parseStringToDate(String text) throws ParseException {
    return new SimpleDateFormat(DATE).parse(text);
  }



}
