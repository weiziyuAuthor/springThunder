package com.yu.spring.good.clazz;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class ClassUtils {

	private static final String ARRAY_SUFFIX = "[]";
	
	private static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";
	
	private static final String INTERNAL_ARRAY_PREFIX = "[";
	
	private static final char PACKAGE_SEPARATOR = '.';
	
	private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap<Class<?>, Class<?>>();
	
	private static final Map<Class<?>, Class<?>> primitiveTypeWrapperMap = new HashMap<Class<?>, Class<?>>();
	
	private static final Map<String, Class<?>> commonClassCache = new HashMap<String, Class<?>>();
	
	private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap<String, Class<?>>();
	
	static {
		primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
		primitiveWrapperTypeMap.put(Integer.class, int.class);
		primitiveWrapperTypeMap.put(Float.class, float.class);
		primitiveWrapperTypeMap.put(Long.class, long.class);
		primitiveWrapperTypeMap.put(Double.class, double.class);
		primitiveWrapperTypeMap.put(Byte.class, byte.class);
		primitiveWrapperTypeMap.put(Character.class, char.class);
		primitiveWrapperTypeMap.put(Short.class, short.class);
		
		for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperTypeMap.entrySet()) {
			primitiveTypeWrapperMap.put(entry.getValue(), entry.getKey());
			registerCommonClasses(entry.getKey());
		}
		
		Set<Class<?>> primitiveTypes = new HashSet<Class<?>>();
		primitiveTypes.addAll(primitiveWrapperTypeMap.values());
		
		primitiveTypes.addAll(Arrays.asList(new Class<?>[]{boolean[].class,
				int[].class, double[].class, float[].class, byte[].class, char[].class,
				short[].class}));
		
		primitiveTypes.add(void.class);
		
		for (Class<?> clazz : primitiveTypes) {
			primitiveTypeNameMap.put(clazz.getName(), clazz);
		}
		
		registerCommonClasses(Boolean[].class, Byte[].class, Character[].class, Double[].class,
				Float[].class, Integer[].class, Long[].class, Short[].class);
		registerCommonClasses(Number.class, Number[].class, String.class, String[].class,
				Object.class, Object[].class, Class.class, Class[].class);
		registerCommonClasses(Throwable.class, Exception.class, RuntimeException.class,
				Error.class, StackTraceElement.class, StackTraceElement[].class);
	}
	
	private static void registerCommonClasses(Class<?>...classes) {
		for (Class<?> clazz: classes) {
			commonClassCache.put(clazz.getName(), clazz);
		}
	}
	
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		
		try {
			cl = Thread.currentThread().getContextClassLoader();
			//good why is not exception
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		if (cl == null) {
			cl = ClassUtils.class.getClassLoader();
			
			if (cl == null) {
				cl = ClassLoader.getSystemClassLoader();
			}
		}
		
		return cl;
	}
	
	public static ClassLoader overrideThreadContextClassLoader(ClassLoader classLoaderToUse) {
		Thread currentThread = Thread.currentThread();
		ClassLoader classLoader = currentThread.getContextClassLoader();
		if (classLoaderToUse != null && !classLoader.equals(classLoaderToUse)) {
			currentThread.setContextClassLoader(classLoaderToUse);
			return classLoader;
		} else {
			return null;
		}
	}
	
	public static Class<?> forName(String name, ClassLoader classLoader) throws ClassNotFoundException {
		Class<?> clazz = resolvePrimitiveClassName(name);
		
		if (clazz == null) {
			clazz = commonClassCache.get(name);
		}
		if (clazz != null){
			return clazz;
		}
		if (name.endsWith(ARRAY_SUFFIX)) {
			String elementClassName = name.substring(0, name.length() - ARRAY_SUFFIX.length());
			Class<?> elementClass = forName(elementClassName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		
		if (name.startsWith(NON_PRIMITIVE_ARRAY_PREFIX) && name.endsWith(";")) {
			String elementName = name.substring(NON_PRIMITIVE_ARRAY_PREFIX.length(), name.length() - 1);
			Class<?> elementClass = forName(elementName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		
		if (name.startsWith(INTERNAL_ARRAY_PREFIX)) {
			String elementName = name.substring(INTERNAL_ARRAY_PREFIX.length());
			Class<?> elementClass = forName(elementName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		
		ClassLoader clToUse = classLoader;
		if (clToUse == null) {
			clToUse = getDefaultClassLoader();
		}
		
		//good, not need return , but needs throws
		try {
			return clToUse != null ? clToUse.loadClass(name) : Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static Class<?> resolvePrimitiveClassName(String name) {
		if (name != null && name.length() < 8) {
			return primitiveTypeNameMap.get(name);
		} else {
			return null;
		}
	}
	
	public static boolean isPresent(String name, ClassLoader classLoader) {
		try {
			forName(name, classLoader);
			return true;
		} catch (Throwable ex) {
			return false;
		}
	}
	
	/**
	 * 从特定类中查找指定方法
	 * 
	 * @param clazz
	 * @param methodName
	 * @param paramTypes
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Method getMethodIfAvailable(Class<?> clazz, String methodName, Class<?>...paramTypes) throws SecurityException, NoSuchMethodException {
		if (paramTypes != null) {
			return clazz.getMethod(methodName, paramTypes);
		} else {
			Set<Method> candidates = new HashSet<Method>(1);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (methodName.equals(method.getName())) {
					candidates.add(method);
				}
			}
			
			if (candidates.size() == 1) {
				return candidates.iterator().next();
			}
		}
		return null;
	}

	public static int getMethodCountForName(Class<?> clazz, String methodName) {
		int count = 0;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method: methods) {
			if (methodName.equals(method.getName())) {
				count++;
			}
		}
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> interfa : interfaces) {
			count += getMethodCountForName(interfa, methodName);
		}
		
		if (clazz.getSuperclass() != null) {
			count += getMethodCountForName(clazz.getSuperclass(), methodName);
		}
		return count;
	}
	
	public static boolean isOrverridable(Method method, Class<?> targetClass) {
		if (Modifier.isFinal(method.getModifiers())) {
			return false;
		}
		
		if (Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
			return false;
		}
		
		return getPackageName(method.getDeclaringClass()).equals(getPackageName(targetClass));
	}
	
	public static String getPackageName(Class<?> clazz) {
		return getPackageName(clazz.getName());
	}
	
	public static String getPackageName(String className) {
		if (className != null) {
			int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
			return lastDotIndex != -1 ? className.substring(0, lastDotIndex) : "";
		}
		return null;
	}
	
	public static boolean isVisiable(Class<?> clazz, ClassLoader classLoader) {
		if (classLoader == null) {
			return true;
		} 
		
		try {
			Class<?> actualClass = classLoader.loadClass(clazz.getName());
			return clazz == actualClass;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
