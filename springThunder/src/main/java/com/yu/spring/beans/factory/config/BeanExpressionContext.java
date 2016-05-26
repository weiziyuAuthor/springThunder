package com.yu.spring.beans.factory.config;

public class BeanExpressionContext {

	private final ConfigurableBeanFactory beanFactory;
	
	private final Scope scope;
	
	public BeanExpressionContext(ConfigurableBeanFactory beanFactory, Scope scope) {
		this.beanFactory = beanFactory;
		this.scope = scope;
	}
	
	public final ConfigurableBeanFactory getBeanFactory() {
		return this.beanFactory;
	}
	
	public final Scope getScope() {
		return this.scope;
	}
	
	public boolean containsObject(String key) {
		return this.beanFactory.containsBean(key) ||
				(this.scope != null && this.scope.resolveContextualObject(key) != null);
	}
	
	public Object getObject(String key) {
		if (this.beanFactory.containsBean(key)) {
			return this.beanFactory.getBean(key);
		} else if (this.scope != null) {
			return this.scope.resolveContextualObject(key);
		} else {
			return null;
		}
	}

	@Override
	public int hashCode() {
		return this.beanFactory.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(this instanceof BeanExpressionContext)) {
			return false;
		}
		BeanExpressionContext otherContext = (BeanExpressionContext)other;
		return this.beanFactory == otherContext.beanFactory && this.scope == otherContext.scope;
	}
	
}
