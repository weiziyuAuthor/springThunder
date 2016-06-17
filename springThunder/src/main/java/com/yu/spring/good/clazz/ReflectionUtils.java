package com.yu.spring.good.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ReflectionUtils {

  // private static final Map<Class<?>, Method[]> declaredMethodsCache = new
  // ConcurrentReferenceHashMap<Class<?>, Method[]>();

  private static final Map<Class<?>, Method[]> declaredMethodsCache =
      new ConcurrentHashMap<Class<?>, Method[]>();

  public static Field findField(Class<?> clazz, String name) {
    return findField(clazz, name, null);
  }

  /**
   * 查找指定类的特定属性
   * 
   * @param clazz
   * @param name
   * @param type
   * @return
   */
  public static Field findField(Class<?> clazz, String name, Class<?> type) {

    Class<?> searchType = clazz;

    while (!Object.class.equals(searchType) && searchType != null) {
      Field[] fields = searchType.getDeclaredFields();
      for (Field field : fields) {
        if ((name == null || name.equals(field.getName()))
            && (type != null || type.equals(field.getType()))) {
          return field;
        }
      }
      searchType = searchType.getSuperclass();
    }
    return null;
  }

  public static void setField(Field field, Object target, Object value) {
    try {
      field.set(target, value);
    } catch (IllegalAccessException e) {
      handleReflectinException(e);
      e.printStackTrace();
    }
  }

  public static Object getField(Field field, Object target) {
    try {
      return field.get(target);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      throw new IllegalStateException(e);
    }
  }

  /**
   * good_tool: Arrays.equals
   * 
   * @param clazz
   * @param name
   * @param paramTypes
   * @return
   */
  public static Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
    Class<?> searchType = clazz;
    while (searchType != null) {
      Method[] methods =
          searchType.isInterface() ? searchType.getMethods() : getDeclaredMethods(searchType);
      for (Method method : methods) {
        if (name.equals(method.getName())
            && (paramTypes == null || Arrays.equals(method.getParameterTypes(), paramTypes))) {
          return method;
        }
      }
      searchType = searchType.getSuperclass();
    }
    return null;
  }

  public static Method findMethod(Class<?> clazz, String name) {
    return findMethod(clazz, name, new Class<?>[0]);
  }

  public static Object invokeMethod(Method method, Object target, Object... args) {
    try {
      return method.invoke(target, args);
    } catch (Exception ex) {
      handleReflectinException(ex);
    }
    throw new IllegalStateException("Should never get here");
  }

  public static Object invokeMethod(Method method, Object target) {
    return invokeMethod(method, target, new Object[0]);
  }

  public static boolean isPublicStaticFinal(Field field) {
    int modifier = field.getModifiers();
    return Modifier.isPublic(modifier) && Modifier.isStatic(modifier) && Modifier.isFinal(modifier);
  }

  public static boolean isEqualsMethod(Method method) {
    if (method == null || !method.getName().equals("equals")) {
      return false;
    }

    Class<?>[] clazz = method.getParameterTypes();
    return clazz.length == 1 && clazz[0] == Object.class;
  }

  public static void makeAccessible(Field field) {
    if ((!Modifier.isPublic(field.getModifiers())
        || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier.isFinal(field
        .getModifiers())) && !field.isAccessible()) {
      field.setAccessible(true);
    }
  }

  /**
   * ?
   * 
   * @param method
   * @return
   */
  public static boolean isObjectMethod(Method method) {
    if (method == null) {
      return false;
    }
    try {
      Object.class.getDeclaredMethod(method.getName(), method.getParameterTypes());
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  public static void doWithMethods(Class<?> clazz, MethodCallback mc) {
    doWithMethods(clazz, mc, null);
  }

  public static void doWithMethods(Class<?> clazz, MethodCallback mc, MethodFilter mf) {
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      if (mf != null && !mf.matches(method)) {
        continue;
      } else {
        mc.doWith(method);
      }
    }
    if (clazz.getSuperclass() != null) {
      doWithMethods(clazz.getSuperclass(), mc, mf);
    } else if (clazz.isInterface()) {
      for (Class<?> superInterfaceClazz : clazz.getInterfaces()) {
        doWithMethods(superInterfaceClazz, mc, mf);
      }
    }
  }

  /**
   * good_idea
   * 
   * @param leafClass
   * @return
   */
  public static Method[] getAllDeclaredMethods(Class<?> leafClass) {
    final List<Method> methods = new ArrayList<Method>();
    doWithMethods(leafClass, new MethodCallback() {
      @Override
      public void doWith(Method method) {
        methods.add(method);
      }
    });
    return methods.toArray(new Method[methods.size()]);
  }

  public static void doWithFields(Class<?> clazz, FieldCallback fc, FieldFilter ff) {
    Class<?> targetClass = clazz;

    do {
      Field[] fields = targetClass.getDeclaredFields();
      for (Field field : fields) {
        if (ff != null && !ff.matches(field)) {
          continue;
        } else {
          fc.doWith(field);
        }
      }
      targetClass = targetClass.getSuperclass();
    } while (targetClass != null && targetClass != Object.class);
  }

  public static void shallowCopyFieldState(final Object src, final Object dest) throws Exception {
    doWithFields(src.getClass(), new FieldCallback() {
      @Override
      public void doWith(Field field) {
        makeAccessible(field);
        try {
          Object srcValue = field.get(src);
          field.set(dest, srcValue);
        } catch (IllegalArgumentException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }, COPYABLE_FIELDS);
  }

  /**
   * good_idea
   * 
   * @param clazz
   * @return
   */
  public static Method[] getDeclaredMethods(Class<?> clazz) {
    Method[] methods = declaredMethodsCache.get(clazz);
    if (methods == null) {
      methods = clazz.getDeclaredMethods();
      declaredMethodsCache.put(clazz, methods);
    }
    return methods;
  }

  public static void handleReflectinException(Exception ex) {
    if (ex instanceof NoSuchMethodException) {
      throw new IllegalStateException("Method not found : " + ex.getMessage());
    }
    if (ex instanceof IllegalAccessException) {
      throw new IllegalStateException("Could not access method: " + ex.getMessage());
    }
    throw new UndeclaredThrowableException(ex);
  }

  public interface MethodCallback {
    void doWith(Method method);
  }

  public interface MethodFilter {
    boolean matches(Method method);
  }

  public interface FieldCallback {
    void doWith(Field field);
  }

  public interface FieldFilter {
    boolean matches(Field field);
  }

  /**
   * good_idea
   */
  public static FieldFilter COPYABLE_FIELDS = new FieldFilter() {
    @Override
    public boolean matches(Field field) {
      return !(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()));
    }

  };
}
