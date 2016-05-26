package com.u.spring.good.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import com.yu.spring.good.clazz.ReflectionUtils;
import com.yu.spring.good.clazz.TestObj;


public class ReflectionUtilsTest {

	
	public static void main(String[] args) throws Exception{
		Field field = ReflectionUtils.findField(TestObjectSubclassWithPublicField.class, "publicField", String.class);
		
		System.out.println(field.getName() + "\t" + field.getType() + "\t" + Modifier.isPublic(field.getModifiers()));
		
		//invokeMethod
		TestObj obj = new TestObj();
		obj.setName("reflection");
		
		Method setName = TestObj.class.getMethod("setName", new Class[]{String.class});
		Method getName = TestObj.class.getMethod("getName", (Class[])null);

		//GOOD method.invoke(target, args);
		ReflectionUtils.invokeMethod(getName, obj);
		System.out.println("reflection".equals(obj.getName()));
		
		String juergen = "juergen";
		ReflectionUtils.invokeMethod(setName, obj, new Object[] { juergen });
		System.out.println(obj.getName());
		
		//MethodCallback
		ListSavingMethodCallback mc = new ListSavingMethodCallback();
		ReflectionUtils.doWithMethods(TestObj.class, mc, new ReflectionUtils.MethodFilter() {
			public boolean matches(Method m) {
				return Modifier.isProtected(m.getModifiers());
			}
		});
		System.out.println(mc.getMethodNames().contains("clone"));
		System.out.println(mc.getMethodNames().contains("getName"));
	}
	
	
	private static class TestObjectSubclassWithPublicField{
		@SuppressWarnings("unused")
		public String publicField = "foo";
	}
	
	private static class ListSavingMethodCallback implements ReflectionUtils.MethodCallback{
		private List<String> methodNames = new LinkedList<String>();

		private List<Method> methods = new LinkedList<Method>();
		
		public void doWith(Method method) {
			this.methodNames.add(method.getName());
			this.methods.add(method);
		}
		
		public List<String> getMethodNames() {
			return this.methodNames;
		}

		public List<Method> getMethods() {
			return this.methods;
		}
	}
	
}
