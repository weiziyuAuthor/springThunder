package com.yu.thingingInJava.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author admin
 * 
 * fail example
 * 
 * 对象的地址
 * 	对象散列码无符号十六进制表示(通过hashCode()生成)
 *
 */
class StringAddress{
	private String s;
	
	public StringAddress(String s) {
		this.s = s;
	}
	
	public String toString() {
		return super.toString() + " " + s;
	}
}

public class FillingLists {

	public static void main(String[] args) {
		List<StringAddress> list = new ArrayList<StringAddress>();
		Collections.nCopies(4, new StringAddress("hello"));
		System.out.println(list);
		
		Collections.fill(list, new StringAddress("world"));
		System.out.println(list);
	}

}
