package com.yu.spring.beans.factory.support;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.yu.spring.core.env.Environment;
import com.yu.spring.core.env.EnvironmentCapable;

/**
 * 
 * @author ziyu.wei
 * 2015年1月21日 下午7:21:59
 * 
 * good
 * 	abstract class (A) implements interface, A's subclass is free (THIN IS BEAUTY) 
 * 	
 */
public abstract class AbstractBeanDefinitionReader implements EnvironmentCapable,
		BeanDefinitionReader {
	
	private final BeanDefinitionRegistry registry;
	
	private ResourceLoader resourceLoader;
	
	private ClassLoader beanClassLoader;
	
	private Environment environment;
	
//	TODO
//	private BeanNameGenerator beanNameGenerator = new DefaultBeanNameGenerator();
	private BeanNameGenerator beanNameGenerator = null;
	
	protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
		if (registry instanceof ResourceLoader) {
			this.resourceLoader = (ResourceLoader)this.registry;
		} else {
			//TODO
			this.resourceLoader =  new PathMatchingResourcePatternResolver();
		}
		
		if (this.registry instanceof EnvironmentCapable) {
			this.environment = ((EnvironmentCapable)this.registry).getEnvironment();
		} else {
//			TODO
//			this.environment = new StandardEnvironment();
		}
	}
	
	public final BeanDefinitionRegistry getRegistry() {
		return this.registry;
	}
	
	public final BeanDefinitionRegistry getBeanFactory() {
		return this.registry;
	}
	
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}
	
	public ClassLoader getBeanClassLoader() {
		return this.beanClassLoader;
	}
	
	public ResourceLoader getResourceLoader() {
		return this.resourceLoader;
	}
	
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Environment getEnvironment() {
		return this.environment;
	}
	
	public void setBeanNameGenerator(BeanNameGenerator beanNameGenerator) {
//		TODO
//		this.beanNameGenerator = (beanNameGenerator != null ? beanNameGenerator : new DefaultBeanNameGenerator());
	}

	public BeanNameGenerator getBeanNameGenerator() {
		return this.beanNameGenerator;
	}
	
	public int loadBeanDefinitions(Resource... resources) {
		int counter = 0;
		for (Resource resource : resources) {
			counter += loadBeanDefinitions(resource);
		}
		return counter;
	}
	
	
	public int loadBeanDefinitions(String location) {
		return loadBeanDefinitions(location, null);
	}
	
	public int loadBeanDefinitions(String location, Set<Resource> actualResources) {
		ResourceLoader resourceLoader = null;
		if (resourceLoader == null) {
//			throw exception
		}
		
		//TODO GOOD
		if (resourceLoader instanceof ResourcePatternResolver) {
			try {
				Resource[] resources = ((ResourcePatternResolver)resourceLoader).getResources(location);
				int loadCount = loadBeanDefinitions(resources);
				if (actualResources != null) {
					for (Resource resource: resources) {
						actualResources.add(resource);
					}
				}
				return loadCount;
			} catch (IOException e) {
				return 0;
			}
			
		} else {
			Resource resource = resourceLoader.getResource(location);
			int loadCount = loadBeanDefinitions(resource);
			if (actualResources != null) {
				actualResources.add(resource);
			}
			return loadCount;
		}
	}
	
	public int loadBeanDefinitions(String... locations) {
		int counter = 0;
		for (String location : locations) {
			counter += loadBeanDefinitions(location);
		}
		return counter;
	}
	
}
