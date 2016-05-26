package com.yu.basic.daily;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLong2Date {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		
		System.out.println(sdf.format(new Date()));
		System.out.println(sdf.format(new Date().getTime()));
		
		System.out.println(sdf.format((new Date().getTime() - 1000 * 60 * 60)));
		System.out.println(new Date().getTime());
		// 1423105846447
		// 1423815025163
	}

}
