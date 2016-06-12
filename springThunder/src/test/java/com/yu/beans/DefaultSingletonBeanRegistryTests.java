package com.yu.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;

public class DefaultSingletonBeanRegistryTests {

  @Test
  public void testSingletons() {
    DefaultSingletonBeanRegistry beanRegistry = new DefaultSingletonBeanRegistry();
    SimpleTestBean stb = new SimpleTestBean();
    beanRegistry.registerSingleton("tb", stb);

    SimpleTestBean stb2 =
        (SimpleTestBean) beanRegistry.getSingleton("tb2", new ObjectFactory<Object>() {
          @Override
          public Object getObject() throws BeansException {
            return new SimpleTestBean();
          }
        });

    assertSame(stb2, beanRegistry.getSingleton("tb2"));
    assertEquals(2, beanRegistry.getSingletonCount());
    String[] names = beanRegistry.getSingletonNames();
    assertEquals(2, names.length);
    assertEquals("tb", names[0]);
    assertEquals("tb2", names[1]);

    beanRegistry.destroySingletons();
    assertEquals(0, beanRegistry.getSingletonCount());
    assertEquals(0, beanRegistry.getSingletonNames().length);
  }
}
