package com.yu.spring.beans.factory.config;

import com.yu.spring.beans.factory.ObjectFactory;

public interface Scope {
	
	Object get(String name, ObjectFactory<?> objectFactory);
	
	Object remove(String name);
	
	void registerDestructionCallback(String name, Runnable callback);
	
	Object resolveContextualObject(String key);
	
	String getConversationId();
	
}
