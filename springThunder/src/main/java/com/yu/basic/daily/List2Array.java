package com.yu.basic.daily;

import java.util.ArrayList;
import java.util.List;

public class List2Array {

	private static String test(String...strs) {
		for (String s : strs) {
			System.out.println(s);
		}
		return null;
	}
	public static void main(String[] args) {
		test("1", "2");
		
		String[] array = new String[2];
		array[0] = "a";
		test(array);
		
		List<String> list = new ArrayList<String>();
		list.add("90");
		list.add("p");
		
		String[] strArr= new String[list.size()];
//		dataList.toArray(strArr);
		
		test(list.toArray(strArr));
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		list.add("e");
//		
//		String[] pics = new String[3];
//		int index = 0;
//		for (String s : list) {
//			if (index > 2) {
//				break;
//			}
//			pics[index] = s;
//			index ++;
//		}
//		
//		System.out.println(pics.length);
	}

}
