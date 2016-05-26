package com.u.spring.aop.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.Pointcuts;
import org.springframework.aop.support.RootClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.u.spring.TestBean;

public class PointcutsTests {
	public static Method TEST_BEAN_SET_AGE;
	public static Method TEST_BEAN_GET_AGE;
	public static Method TEST_BEAN_GET_NAME;
	public static Method TEST_BEAN_ABSQUATULATE;

	static {
		try {
			TEST_BEAN_SET_AGE = TestBean.class.getMethod("setAge", new Class[] { int.class });
			TEST_BEAN_GET_AGE = TestBean.class.getMethod("getAge", (Class[]) null);
			TEST_BEAN_GET_NAME = TestBean.class.getMethod("getName", (Class[]) null);
			TEST_BEAN_ABSQUATULATE = TestBean.class.getMethod("absquatulate", (Class[]) null);
		}
		catch (Exception ex) {
			throw new RuntimeException("Shouldn't happen: error in test suite");
		}
	}
	
	/**
	 * Matches only TestBean class, not subclasses
	 */
	public static Pointcut allTestBeanMethodsPointcut = new StaticMethodMatcherPointcut() {
		@Override
		public ClassFilter getClassFilter() {
			return new ClassFilter() {
				@Override
				public boolean matches(Class<?> clazz) {
					return clazz.equals(TestBean.class);
				}
			};
		}

		@Override
		public boolean matches(Method m, Class<?> targetClass) {
			return true;
		}
	};
	
	public static Pointcut allClassSetterPointcut = Pointcuts.SETTERS;

	// Subclass used for matching
	public static class MyTestBean extends TestBean {
	}

	public static Pointcut myTestBeanSetterPointcut = new StaticMethodMatcherPointcut() {
		@Override
		public ClassFilter getClassFilter() {
			return new RootClassFilter(MyTestBean.class);
		}

		@Override
		public boolean matches(Method m, Class<?> targetClass) {
			return m.getName().startsWith("set");
		}
	};
	
	// Will match MyTestBeanSubclass
	public static Pointcut myTestBeanGetterPointcut = new StaticMethodMatcherPointcut() {
		@Override
		public ClassFilter getClassFilter() {
			return new RootClassFilter(MyTestBean.class);
		}

		public boolean matches(Method m, Class<?> targetClass) {
			return m.getName().startsWith("get");
		}
	};
	
	// Still more specific class
	public static class MyTestBeanSubclass extends MyTestBean {
	}

	public static Pointcut myTestBeanSubclassGetterPointcut = new StaticMethodMatcherPointcut() {
		@Override
		public ClassFilter getClassFilter() {
			return new RootClassFilter(MyTestBeanSubclass.class);
		}

		@Override
		public boolean matches(Method m, Class<?> targetClass) {
			return m.getName().startsWith("get");
		}
	};

	public static Pointcut allClassGetterPointcut = Pointcuts.GETTERS;

	public static Pointcut allClassGetAgePointcut = new NameMatchMethodPointcut().addMethodName("getAge");

	public static Pointcut allClassGetNamePointcut = new NameMatchMethodPointcut().addMethodName("getName");
	
	@Test
	public void testTrue() {
		assertTrue(Pointcuts.matches(Pointcut.TRUE, TEST_BEAN_SET_AGE, TestBean.class, new Object[] { new Integer(16)}));
		assertTrue(Pointcuts.matches(Pointcut.TRUE, TEST_BEAN_GET_AGE, TestBean.class, null));
		assertTrue(Pointcuts.matches(Pointcut.TRUE, TEST_BEAN_ABSQUATULATE, TestBean.class, null));
		assertTrue(Pointcuts.matches(Pointcut.TRUE, TEST_BEAN_SET_AGE, TestBean.class, new Object[] { new Integer(6)}));
		assertTrue(Pointcuts.matches(Pointcut.TRUE, TEST_BEAN_GET_AGE, TestBean.class, null));
		assertTrue(Pointcuts.matches(Pointcut.TRUE, TEST_BEAN_ABSQUATULATE, TestBean.class, null));
	}
	
	@Test
	public void testMatches() {
		assertTrue(Pointcuts.matches(allClassSetterPointcut, TEST_BEAN_SET_AGE, TestBean.class, new Object[] { new Integer(6)}));
		assertFalse(Pointcuts.matches(allClassSetterPointcut, TEST_BEAN_GET_AGE, TestBean.class, null));
		assertFalse(Pointcuts.matches(allClassSetterPointcut, TEST_BEAN_ABSQUATULATE, TestBean.class, null));
		assertFalse(Pointcuts.matches(allClassGetterPointcut, TEST_BEAN_SET_AGE, TestBean.class, new Object[] { new Integer(6)}));
		assertTrue(Pointcuts.matches(allClassGetterPointcut, TEST_BEAN_GET_AGE, TestBean.class, null));
		assertFalse(Pointcuts.matches(allClassGetterPointcut, TEST_BEAN_ABSQUATULATE, TestBean.class, null));
	}
}
