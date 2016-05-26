package com.yu.spring.beans.factory.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

import com.yu.spring.beans.BeanMetadataElement;

public interface BeanDefinition extends BeanMetadataElement {
	
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
	
	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;
	
	int ROLE_APPLICATION = 0;
	
	int ROLE_SUPPORT = 1;
	
	int ROLE_INFRASTRUCTURE = 2;
	
	String getParentName();
	
	void setParentName(String parentName);
	
	String getBeanClassName();
	
	String getFactoryBeanName();
	
	void setFactoryBeanName(String factoryBeanName);
	
	String getFactoryMethodName();
	
	String setFactoryMethodName(String factoryMethodName);
	
	String getScope();
	
	void setScope(String scope);
	
	boolean isLazyInit();
	
	String[] getDependsOn();
	
	void setDependsOn(String...dependsOn);
	
	boolean isAutowireCandidate();
	
	void setAutowireCandidate(boolean autowireCandidate);
	
	boolean isPrimary();
	
	void setPrimary(boolean primary);
	
	//TODO
	ConstructorArgumentValues getConstructorArgumentValues();
	
	//TODO
	MutablePropertyValues getPropertyValues();
	
	boolean isSingleton();
	
	boolean isPrototype();
	
	boolean isAbstract();
	
	int getRole();
	
	String getDescription();
	
	String getResourceDescription();
	
	BeanDefinition getOriginitingBeanDefinition();
	
}
