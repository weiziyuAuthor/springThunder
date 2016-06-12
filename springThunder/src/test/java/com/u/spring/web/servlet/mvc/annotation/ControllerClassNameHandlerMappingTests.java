package com.u.spring.web.servlet.mvc.annotation;

import junit.framework.TestCase;

import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerMapping;


public class ControllerClassNameHandlerMappingTests extends TestCase{
	public static final String LOCATION = "/org/springframework/web/servlet/mvc/annotation/class-mapping.xml";

	private XmlWebApplicationContext wac;

	private HandlerMapping hm;

	private HandlerMapping hm2;

	private HandlerMapping hm3;

	private HandlerMapping hm4;

  // @Override
  // public void setUp() throws Exception {
  // MockServletContext sc = new MockServletContext("");
  // this.wac = new XmlWebApplicationContext();
  // System.out.println("wac: " + this.wac);
  // // this.wac.setServletContext(sc);
  // // this.wac.setConfigLocations(new String[] {LOCATION});
  // this.wac.refresh();
  // this.hm = (HandlerMapping) this.wac.getBean("mapping");
  // this.hm2 = (HandlerMapping) this.wac.getBean("mapping2");
  // this.hm3 = (HandlerMapping) this.wac.getBean("mapping3");
  // this.hm4 = (HandlerMapping) this.wac.getBean("mapping4");
  // }

  // public void testIndexUri() throws Exception {
  // MockHttpServletRequest request = new MockHttpServletRequest("GET", "/index");
  // HandlerExecutionChain chain = this.hm.getHandler(request);
  // System.out.println("chain: " + chain);
  // assertEquals(this.wac.getBean("index"), chain.getHandler());
  //
  // request = new MockHttpServletRequest("GET", "/index/product");
  // chain = this.hm.getHandler(request);
  // assertEquals(this.wac.getBean("index"), chain.getHandler());
  // }
}
