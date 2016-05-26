package com.yu.basic.daily;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Stu {
	private String name;
	
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class ReflectGetValue {

//	if (StringUtils.isNotBlank(bean.getUserId())) {
//		parameterMap.put("userId", bean.getUserId());
//	}

	public static void main(String[] args) {
		Stu stu = new Stu();
		stu.setName("weizy");
		
		List<String> getNamesList = new ArrayList<String>();
		Method[] methodes = Stu.class.getDeclaredMethods();
		for (Method method : methodes) {
			if (method.getName().startsWith("get")) {
//				System.out.println(method.getName());
				String name = method.getName().substring(3, method.getName().length());
				name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
				getNamesList.add(name);
			}
		}
		
		for (String name : getNamesList) {
			System.out.println("name: " + name);
		}
		
		Field[] fieldes = Stu.class.getDeclaredFields();
		for (Field field : fieldes) {
			if (getNamesList.contains(field.getName())) {
				try {
					
					field.setAccessible(true);
					System.out.println("result: " +field.get(stu) 
										+ "\tDDDD " + field.getType().equals(String.class));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		//-------------------------------
		Method[] methods = Stu.class.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("set")) {
				System.out.println(method.getName());
			}
		}
		
		Field[] fields = Stu.class.getDeclaredFields();
		for (Field field : fields) {
			
			try {
				field.setAccessible(true);
				System.out.println("result: " + field.get(stu) + "type: " + field.getType() instanceof String);
//				System.out.println("result: " + field.get(stu) + "type: " + field.getType() instanceof String.class );
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}

}
