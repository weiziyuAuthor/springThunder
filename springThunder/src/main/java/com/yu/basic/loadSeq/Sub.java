package com.yu.basic.loadSeq;

public class Sub extends Base {

	private static String b = "NB";
	
	private String j = "NB";
	
	{
		j = "B";
		System.out.println(j);
	}
	
	static {
		b = "Static Sub";
		System.out.println(b);
	}
	
	public Sub() {
		System.out.println("Construct Sub");
	}
}
