package com.yu.beans;

import java.lang.reflect.Method;
import java.util.Map;

import com.yu.spring.good.clazz.ReflectionUtils;
public class AutowireUtilsTest {


  public void genericMethodReturnTypes() {
    Method notParameterized =
        ReflectionUtils.findMethod(MyTypeWithMethods.class, "notParameterized", new Class[] {});
    assertEquals(String.class, AutowireUtils.resolveReturnTypeForFactoryMethod(notParameterized,
        new Object[] {}, getClass().getClassLoader()));
  }
  public interface MyInterfaceType<T> {

  }

  public class MySimpleInterfaceType implements MyInterfaceType<String> {

  }

  public static class MyTypeWithMethods<T> {

    public MyInterfaceType<Integer> integer() {
      return null;
    }

    public MySimpleInterfaceType string() {
      return null;
    }

    public Object object() {
      return null;
    }

    @SuppressWarnings("rawtypes")
    public MyInterfaceType raw() {
      return null;
    }

    public String notParameterized() {
      return null;
    }

    public String notParameterizedWithArguments(Integer x, Boolean b) {
      return null;
    }

    public static <T> T createProxy(T object) {
      return null;
    }

    public static <T> T createNameProxy(String name, T object) {
      return null;
    }

    public static <MOCK> MOCK createMOCK(Class<MOCK> toMock) {
      return null;
    }

    public static <T> T createNamedMock(String name, Class<T> toMock) {
      return null;
    }

    public static <V extends Object, T> T createVMock(V name, Class<T> toMock) {
      return null;
    }

    public static <T> T extractValueFrom(MyInterfaceType<T> myInterfaceType) {
      return null;
  }
    public static <K, V> V extractMagicValue(Map<K, V> map) {
      return null;
  }

  public void readIntegerInputMessage(MyInterfaceType<Integer> message) {
  }

  public void readIntegerArrayInputMessage(MyInterfaceType<Integer>[] message) {
  }

  public void readGenericArrayInputMessage(T[] message) {
  }


  }

}
