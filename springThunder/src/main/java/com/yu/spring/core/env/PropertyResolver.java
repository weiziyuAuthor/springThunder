package com.yu.spring.core.env;

public interface PropertyResolver {

	boolean containsProperty(String key);
	
	String getProperty(String key);
	
	String getProperty(String key, String defaultValue);
	
	<T> T getProperty(String key, Class<T> targetType);
	
	<T> T getProperty(String key, Class<T> targetType, T defaultValue);
	
	<T> T getProperyAsClass(String key, Class<T> targetType);
	
	String getRequiredProperty(String key);
	
	<T> T getRequiredProperty(String key, Class<T> targetType);
	
	String resolverPlaceHolders(String text);
	
	String resolverRequiredPlaceHolders(String text);
	
}
