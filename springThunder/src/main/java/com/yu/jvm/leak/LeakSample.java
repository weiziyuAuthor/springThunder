package com.yu.jvm.leak;

import java.util.Vector;

public class LeakSample {

	public static void main(String[] args) {
		Vector v = new Vector(10);
		for (int i=0; i<5000; i++) {
			Object o = new Object();
			v.add(o);
			o = null;
		}
	}

}
