package com.yu.spring.beans.factory.support;

import com.yu.spring.beans.factory.config.BeanDefinition;
import com.yu.spring.core.AliasRegistry;

public interface BeanDefinitionRegistry extends AliasRegistry {
	
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
	
	void removeBeanDefinition(String beanName);
	
	BeanDefinition getBeanDefinition(String beanName);
	
	boolean containsBeanDefinition(String beanName);
	
	String[] getBeanDefinitionNames();
	
	int getBeanDefinitionCount();
	
	boolean isBeanNameInUse(String beanName);
}
