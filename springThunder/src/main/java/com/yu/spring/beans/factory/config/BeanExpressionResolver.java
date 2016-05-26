package com.yu.spring.beans.factory.config;

public interface BeanExpressionResolver {
	
	Object evaluate(String value, BeanExpressionContext evalContext);
}
