package com.yu.spring.core;

public interface AliasRegistry {

	void registerAlias(String name, String alias);
	
	void removeAlias(String alias);
	
	boolean isAlias(String beanName);
	
	String[] getAlias(String name);
}
