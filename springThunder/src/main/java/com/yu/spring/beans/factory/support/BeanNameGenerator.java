package com.yu.spring.beans.factory.support;

import com.yu.spring.beans.factory.config.BeanDefinition;

public interface BeanNameGenerator {

	String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry registry);
}
