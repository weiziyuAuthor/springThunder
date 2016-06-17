package com.yu.beans;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
public class FactoryBeanLookupTests {

  private BeanFactory beanFactory;

  @Before
  public void setUp() {
    beanFactory = new DefaultListableBeanFactory();
    new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory)
        .loadBeanDefinitions(new ClassPathResource("FactoryBeanLookupTests-context.xml", this
            .getClass()));
  }


  @Test
  public void factoryBeanLookupByNameDereferencing() {
    Object fooFactory = beanFactory.getBean("&fooFactory");
    assertThat(fooFactory, instanceOf(FooFactoryBean.class));
  }
}


class FooFactoryBean extends AbstractFactoryBean<Foo> {
  @Override
  protected Foo createInstance() throws Exception {
    return new Foo();
  }

  @Override
  public Class<?> getObjectType() {
    return Foo.class;
  }
}


class Foo {}
