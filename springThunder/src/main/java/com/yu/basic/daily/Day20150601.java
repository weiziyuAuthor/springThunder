package com.yu.basic.daily;

import java.lang.reflect.Field;

public class Day20150601 {
	public static void main(String[] args) {
		
		Model model = new Model();
		Class clazz = model.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getType());
		}
	}
}

class Model{
	private String name;

	private Long time;
	
	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}