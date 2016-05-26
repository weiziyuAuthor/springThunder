package com.yu.spring.beans.factory;

public interface BeanFactory {
	
	String FACTORY_BEAN_PREFIX = "&";
	
	Object getBean(String beanName);
	
	<T> T getBean(String name, Class<T> requiredType);
	
	<T> T getBean(Class<T> requiredType);
	
	Object getBean(String name, Object... args);
	
	<T> T getBean(Class<T> requiredType, Object... args);
	
	boolean containsBean(String name);
	
	boolean isSingleton(String name);
	
	boolean isPrototype(String name);
	
	boolean isTypeMatch(String name, Class<?> targetType);
	
	Class<?> getType(String name);
	
	String[] getAlias(String name);
}
