package com.yu.spring.beans.factory.config;

import java.beans.PropertyEditor;
import java.security.AccessControlContext;

import org.springframework.beans.TypeConverter;

import com.yu.spring.StringValueResolver;
import com.yu.spring.beans.PropertyEditorRegistrar;
import com.yu.spring.beans.PropertyEditorRegistry;
import com.yu.spring.beans.factory.BeanFactory;
import com.yu.spring.beans.factory.HierarchicalBeanFactory;
import com.yu.spring.core.convert.ConversionService;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,
		SingletonBeanRegistry {
	
	String SCOPE_SINGLETON = "singleton";
	
	String SCOPE_PROTOTYPE = "prototype";
	
	void setParentBeanFactory(BeanFactory parentBeanFactory);
	
	void setBeanClassLoader(ClassLoader beanClassLoader);
	
	ClassLoader getBeanClassLoader();
	
	void setTempClassLoader(ClassLoader tempClassLoader);
	
	ClassLoader getTempClassLoader();
	
	void setCacheBeanMetadata(boolean cacheBeanMetadata);
	
	boolean isCacheBeanMetadata();
	
	void setBeanExpressionResolver(BeanExpressionResolver resolver);
	
	BeanExpressionResolver getBeanExpressionResolver();
	
	void setConversionService(ConversionService service);
	
	ConversionService getConversionService();
	
	void addPropertyEditorRegistrar(PropertyEditorRegistrar registrar);
	
	void registerCustomerEditor(Class<?> requiredType, Class<? extends PropertyEditor> propertyEditorClass);
	
	void copyRegisteredEditorTo(PropertyEditorRegistry registry);
	
//	TODO
	void setTypeConverter(TypeConverter converter);
	
//	TODO
	TypeConverter getTypeConverter();
	
	void addEmbeddedValueResolver(StringValueResolver valueResolver);
	
	String resolverEmbeddedValue(String value);
	
	void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
	
	int getBeanPostProcessorCount();
	
	void registerScope(String scopeName, Scope scope);
	
	String[] getRegisterScopeNames();
	
	Scope getRegisterScope(String scopeName);
	
	AccessControlContext getAccessControlContext();
	
	void copyConfigurationForm(ConfigurableBeanFactory otherFactory);
	
	void registerAlias(String beanName, String alias);
	
	BeanDefinition getMergedBeanDefinition(String beanName);
	
	boolean isFactoryBean(String name);
	
	void setCurrentlyInCreation(String beanName);
	
	void registerDependentBean(String beanName, String dependentBeanName);
	
	String[] getDependentBeans(String beanName);
	
	void destoryBean(String beanName, Object beanInstance);
	
	void destoryScopedBean(String beanName);
	
	void destorySingletons();
	
}
