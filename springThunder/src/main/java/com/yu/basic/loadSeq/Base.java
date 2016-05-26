package com.yu.basic.loadSeq;

public class Base {

	private static String a = "NA";
	
	private String i = "NA";
	
	{
		i = "A";
		System.out.println(i);
	}
	
	static {
		a = "Static Base";
		System.out.println(a);
	}
	
	public Base() {
		System.out.println("Construct Base");
	}
}
