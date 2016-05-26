package com.yu.basic.daily;

public class ModeTest {

	public static void main(String[] args) {
//		System.out.println("a");
//		
		String string = "03DF692B000F275CE053C66EA8C063FC".substring(0, 10); //16633113344
//		String string = "03DF692B052F275CE053C66EA8C063FC".substring(0, 10); //16633113344
		
		long i = Long.parseLong(string, 16) % 12;
		
		System.out.println("i: " + i);
	}

}
