package com.u.spring.web.servlet.mvc;

import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.support.WebContentGenerator;

import com.u.spring.mock.web.test.MockHttpServletRequest;
import com.u.spring.mock.web.test.MockHttpServletResponse;


public class WebContentInterceptorTests extends TestCase{


	private MockHttpServletRequest request;

	private MockHttpServletResponse response;


	@Before
	public void setUp() throws Exception {
		request = new MockHttpServletRequest();
		request.setMethod(WebContentGenerator.METHOD_GET);
		response = new MockHttpServletResponse();
	}


//	@Test
	public void testpreHandleSetsCacheSecondsOnMatchingRequest() throws Exception {
		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(10);

		interceptor.preHandle(request, response, null);

		List expiresHeaders = response.getHeaders("Expires");
		assertNotNull("'Expires' header not set (must be) : null", expiresHeaders);
		assertTrue("'Expires' header not set (must be) : empty", expiresHeaders.size() > 0);
		List cacheControlHeaders = response.getHeaders("Cache-Control");
		assertNotNull("'Cache-Control' header not set (must be) : null", cacheControlHeaders);
		assertTrue("'Cache-Control' header not set (must be) : empty", cacheControlHeaders.size() > 0);
	}

	@Test
	public void preHandleSetsCacheSecondsOnMatchingRequestWithCustomCacheMapping() throws Exception {
		Properties mappings = new Properties();
		mappings.setProperty("**/*handle.vm", "-1");

		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(10);
		interceptor.setCacheMappings(mappings);

		request.setRequestURI("http://localhost:7070/example/adminhandle.vm");
		interceptor.preHandle(request, response, null);

		List expiresHeaders = response.getHeaders("Expires");
		assertSame("'Expires' header set (must not be) : empty", 0, expiresHeaders.size());
		List cacheControlHeaders = response.getHeaders("Cache-Control");
		assertSame("'Cache-Control' header set (must not be) : empty", 0, cacheControlHeaders.size());

		request.setRequestURI("http://localhost:7070/example/bingo.html");
		interceptor.preHandle(request, response, null);

		expiresHeaders = response.getHeaders("Expires");
		assertNotNull("'Expires' header not set (must be) : null", expiresHeaders);
		assertTrue("'Expires' header not set (must be) : empty", expiresHeaders.size() > 0);
		cacheControlHeaders = response.getHeaders("Cache-Control");
		assertNotNull("'Cache-Control' header not set (must be) : null", cacheControlHeaders);
		assertTrue("'Cache-Control' header not set (must be) : empty", cacheControlHeaders.size() > 0);
	}

	@Test
	public void preHandleSetsCacheSecondsOnMatchingRequestWithNoCaching() throws Exception {
		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(0);

		interceptor.preHandle(request, response, null);

		List expiresHeaders = response.getHeaders("Expires");
		assertNotNull("'Expires' header not set (must be) : null", expiresHeaders);
		assertTrue("'Expires' header not set (must be) : empty", expiresHeaders.size() > 0);
		List cacheControlHeaders = response.getHeaders("Cache-Control");
		assertNotNull("'Cache-Control' header not set (must be) : null", cacheControlHeaders);
		assertTrue("'Cache-Control' header not set (must be) : empty", cacheControlHeaders.size() > 0);
	}

	@Test
	public void preHandleSetsCacheSecondsOnMatchingRequestWithCachingDisabled() throws Exception {
		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(-1);

		interceptor.preHandle(request, response, null);

		List expiresHeaders = response.getHeaders("Expires");
		assertSame("'Expires' header set (must not be) : empty", 0, expiresHeaders.size());
		List cacheControlHeaders = response.getHeaders("Cache-Control");
		assertSame("'Cache-Control' header set (must not be) : empty", 0, cacheControlHeaders.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPathMatcherToNull() throws Exception {
				WebContentInterceptor interceptor = new WebContentInterceptor();
				interceptor.setPathMatcher(null);
	}


}
