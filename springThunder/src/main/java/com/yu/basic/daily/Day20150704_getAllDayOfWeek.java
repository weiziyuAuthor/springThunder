package com.yu.basic.daily;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Day20150704_getAllDayOfWeek {

	private static final int FIRST_DAY = Calendar.MONDAY;
	 
    private static void printWeekdays() {
        Calendar calendar = Calendar.getInstance();
        setToFirstDay(calendar);
        for (int i = 0; i < 7; i++) {
            printDay(calendar);
            calendar.add(Calendar.DATE, 1);
        }
    }
 
    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
 
    private static void printDay(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd EE");
        System.out.println(dateFormat.format(calendar.getTime()));
    }
 
    
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.DAY_OF_WEEK - 6);
		printWeekdays();
	}

}
