package com.u.spring.web.servlet.config;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.util.UrlPathHelper;

public class AnnotationDrivenBeanDefinitionParserTests {

	private GenericWebApplicationContext appContext;
	
	@Before
	public void setup() {
		appContext = new GenericWebApplicationContext();
	}
	
	@Test
	public void testMessageCodesResolver() {
		loadBeanDefinitions("mvc-config-message-codes-resolver.xml");
		RequestMappingHandlerAdapter adapter = appContext.getBean(RequestMappingHandlerAdapter.class);
		assertNotNull(adapter);
		Object initializer = adapter.getWebBindingInitializer();
		assertNotNull(initializer);
		MessageCodesResolver resolver = ((ConfigurableWebBindingInitializer) initializer).getMessageCodesResolver();
		assertNotNull(resolver);
		assertEquals(TestMessageCodesResolver.class, resolver.getClass());
		assertEquals(false, new DirectFieldAccessor(adapter).getPropertyValue("ignoreDefaultModelOnRedirect"));
	}
	
	@Test
	public void testMessageConverters() {
		loadBeanDefinitions("mvc-config-message-converters.xml");
		verifyMessageConverters(appContext.getBean(RequestMappingHandlerAdapter.class), true);
//		verifyMessageConverters(appContext.getBean(ExceptionHandlerExceptionResolver.class), true);
//		verifyResponseBodyAdvice(appContext.getBean(RequestMappingHandlerAdapter.class));
//		verifyResponseBodyAdvice(appContext.getBean(ExceptionHandlerExceptionResolver.class));
	}
	
	@Test
	public void testPathMatchingConfiguration() {
		loadBeanDefinitions("mvc-config-path-matching.xml");
		RequestMappingHandlerMapping hm = appContext.getBean(RequestMappingHandlerMapping.class);
		assertNotNull(hm);
		assertTrue(hm.useSuffixPatternMatch());
		assertFalse(hm.useTrailingSlashMatch());
		assertTrue(hm.useRegisteredSuffixPatternMatch());
		List<String> fileExtensions = hm.getContentNegotiationManager().getAllFileExtensions();
		for (String name : fileExtensions) {
			System.out.println("name: " + name);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void verifyResponseBodyAdvice(Object bean) {
		assertNotNull(bean);
		Object value = new DirectFieldAccessor(bean).getPropertyValue("responseBodyAdvice");
		assertNotNull(value);
		assertTrue(value instanceof List);
		List<ResponseBodyAdvice> converters = (List<ResponseBodyAdvice>) value;
		assertTrue(converters.get(0) instanceof JsonViewResponseBodyAdvice);
	}
	
	@SuppressWarnings("unchecked")
	private void verifyMessageConverters(Object bean, boolean hasDefaultRegistrations) {
		Object value = new DirectFieldAccessor(bean).getPropertyValue("messageConverters");
		assertNotNull(value);
		assertTrue(value instanceof List);
		List<HttpMessageConverter<?>> converters = (List<HttpMessageConverter<?>>) value;
		if (hasDefaultRegistrations) {
			assertTrue("Default converters are registered in addition to custom ones", converters.size() > 2);
		} else {
			assertTrue("Default converters should not be registered", converters.size() == 2);
		}
		assertTrue(converters.get(0) instanceof StringHttpMessageConverter);
		assertTrue(converters.get(1) instanceof ResourceHttpMessageConverter);
	}
	
	private void loadBeanDefinitions(String fileName) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(appContext);
		ClassPathResource resource = new ClassPathResource(fileName, AnnotationDrivenBeanDefinitionParserTests.class);
		reader.loadBeanDefinitions(resource);
		appContext.refresh();
	}
	

}
class TestMessageCodesResolver implements MessageCodesResolver {

	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName) {
		return new String[] { "test.foo.bar" };
	}

	@Override
	@SuppressWarnings("rawtypes")
	public String[] resolveMessageCodes(String errorCode, String objectName, String field, Class fieldType) {
		return new String[] { "test.foo.bar" };
	}

}

class TestPathMatcher extends AntPathMatcher { }

class TestPathHelper extends UrlPathHelper { }
