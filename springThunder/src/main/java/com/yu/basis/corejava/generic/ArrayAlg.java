package com.yu.basis.corejava.generic;

/**
 * 泛型方法
 *
 * 类型变量放在修饰符(public static)的后面， 返回类型的前面
 *
 * @author ziyu.wei@tendcloud.com
 *
 *         2015年12月12日 下午2:20:22
 */
public class ArrayAlg {

  public static <T> T getMiddle(T[] a) {
    return a[a.length / 2];
  }

  // common method
  public static String getString() {
    return null;
  }
}


class ArrayAlg1 {
  // almost correct
  // public static <T> T min(T[] a) {
  // if (a == null || a.length == 0) {
  // return null;
  // }
  //
  // T smallest = a[0];
  // for (int i = 1; i < a.length; i++) {
  // if (smallest.compareTo(a[i]) > 0) {
  // smallest = a[i];
  // }
  // }
  // return smallest;
  // }
}


/**
 * <T extends BoundingType>
 *
 * 表示T应该是绑定类型的子类型(subtype). T和绑定类型可以是类，也可以是接口。选择关键字extends是因为它更接近之类的概念
 *
 * 一个类型变量或通配符可以有多个限定 T extends Comparable & Serializable, 限定类型用"&"分隔
 *
 *
 */
class ArrayAlg2 {

  public static <T extends Comparable> T min(T[] a) {
    if (a == null || a.length == 0) {
      return null;
    }

    T smallest = a[0];
    for (int i = 1; i < a.length; i++) {
      if (smallest.compareTo(a[i]) > 0) {
        smallest = a[i];
      }
    }
    return smallest;
  }
}


class ArrayAlg3 {
  public static <T extends Comparable> Pair<T> minMax(T[] a) {
    if (a == null || a.length == 0) {
      return null;
    }

    T min = a[0];
    T max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (min.compareTo(a[i]) > 0) {
        min = a[i];
      }
      if (min.compareTo(a[i]) < 0) {
        max = a[i];
      }
    }

    return new Pair<T>(min, max);
  }
}

/*
 * 一个类和一个子类 Employee和Manager
 * 
 * Pair<Manager>不是Pair<Employee>的子类
 * 
 * 通配符类型Pair<? extends Employee>, 表示任何泛型Pair类型， 它的类型参数是Employee的子类，如 Pair<Manager>
 * 
 * 
 * 
 * 通配符的超类型限定
 * 
 * ? super Manager, 这个通配符限制为Manager的所有超类型
 * 
 * 
 * 无限定通配符
 * 
 * Pair<?>
 */