package com.TD.dailyTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test0811 {

  private static String getDate(int scope) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

    Date endTime = new Date();
    System.out.println(sdf.format(endTime));
    Calendar cal = Calendar.getInstance();
    cal.setTime(endTime);
    cal.add(Calendar.DATE, -2);
    String endTimeStr = sdf.format(cal.getTime());

    cal.add(Calendar.DATE, 1 - scope);
    String startTimeStr = sdf.format(cal.getTime());

    String date = startTimeStr + "," + endTimeStr;// 根据scope得到覆盖历史数据的范围

    return date;
  }

  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public static void main(String[] args) {
    System.out.println(getDate(90));

    System.out.println(Float.isNaN(0));


    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.HOUR_OF_DAY, -1);
    String date = sdf.format(cal.getTime());
    System.out.println(date);
  }

}
