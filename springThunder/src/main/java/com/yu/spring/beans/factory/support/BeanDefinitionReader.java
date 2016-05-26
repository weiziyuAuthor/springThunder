package com.yu.spring.beans.factory.support;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {
	
//	TODO
	BeanDefinitionRegistry getRegistry();
	
	ResourceLoader getResourceLoader();
	
	ClassLoader getBeanClassLoader();
	
//	TODO
//	BeanNameGenerator getBeanNameGenerator();
	
	int loadBeanDefinitions(Resource resource);
	
	int loadBeanDefinitions(Resource... resources);
	
	int loadBeanDefinitions(String location);
	
	int loadBeanDefinitions(String... locations);
	
}
