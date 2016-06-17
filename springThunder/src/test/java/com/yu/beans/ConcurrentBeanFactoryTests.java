package com.yu.beans;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author ziyu.wei@tendcloud.com
 * 
 *         2016年6月17日 下午3:36:00
 *
 *         测试并发的好思路
 */
public class ConcurrentBeanFactoryTests {

  private static final Log logger = LogFactory.getLog(ConcurrentBeanFactoryTests.class);
//  private static final Resource CONTEXT = qualifiedResource(ConcurrentBeanFactoryTests.class,
//      "context.xml");
  private static final Resource CONTEXT =
 new ClassPathResource(format("%s-%s",
      ConcurrentBeanFactoryTests.class.getSimpleName(), "context.xml"),
      ConcurrentBeanFactoryTests.class);

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
  private static final Date DATE_1, DATE_2;

  static {
    try {
      DATE_1 = DATE_FORMAT.parse("2004/08/08");
      DATE_2 = DATE_FORMAT.parse("2000/02/02");
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }


  private BeanFactory factory;

  private final Set<TestRun> set = Collections.synchronizedSet(new HashSet<TestRun>());

  private Throwable ex = null;

  @Before
  public void setUp() throws Exception {
    // Assume.group(TestGroup.PERFORMANCE);

    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    new XmlBeanDefinitionReader(factory).loadBeanDefinitions(CONTEXT);
    factory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {

      @Override
      public void registerCustomEditors(org.springframework.beans.PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class,
            new CustomDateEditor((DateFormat) DATE_FORMAT.clone(), false));
      }
    });
    this.factory = factory;
  }

  @Test
  public void testSingleThread() {
    for (int i = 0; i < 100; i++) {
      performTest();
    }
  }

  @Test
  public void testConcurrent() {
    for (int i = 0; i < 100; i++) {
      TestRun run = new TestRun();
      run.setDaemon(true);
      set.add(run);
    }
    for (Iterator<TestRun> it = new HashSet<TestRun>(set).iterator(); it.hasNext();) {
      TestRun run = it.next();
      run.start();
    }
    logger.info("Thread creation over, " + set.size() + " still active.");
    synchronized (set) {
      while (!set.isEmpty() && ex == null) {
        try {
          set.wait();
        } catch (InterruptedException e) {
          logger.info(e.toString());
        }
        logger.info(set.size() + " threads still active.");
      }
    }
    if (ex != null) {
      // fail(ex.getMessage());
    }
  }

  private void performTest() {
    ConcurrentBean b1 = (ConcurrentBean) factory.getBean("bean1");
    ConcurrentBean b2 = (ConcurrentBean) factory.getBean("bean2");

    assertEquals(b1.getDate(), DATE_1);
    assertEquals(b2.getDate(), DATE_2);
  }

  private class TestRun extends Thread {

    @Override
    public void run() {
      try {
        for (int i = 0; i < 10000; i++) {
          performTest();
        }
      } catch (Throwable e) {
        ex = e;
      } finally {
        synchronized (set) {
          set.remove(this);
          set.notifyAll();
        }
      }
    }
  }

  public static class ConcurrentBean {

    private Date date;

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }
  }

}
