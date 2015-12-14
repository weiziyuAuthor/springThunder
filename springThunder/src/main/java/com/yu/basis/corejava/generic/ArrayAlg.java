package com.yu.basis.corejava.generic;

/**
 * ���ͷ���
 *
 * ���ͱ����������η�(public static)�ĺ��棬 �������͵�ǰ��
 *
 * @author ziyu.wei@tendcloud.com
 *
 *         2015��12��12�� ����2:20:22
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
 * ��ʾTӦ���ǰ����͵�������(subtype). T�Ͱ����Ϳ������࣬Ҳ�����ǽӿڡ�ѡ��ؼ���extends����Ϊ�����ӽ�֮��ĸ���
 *
 * һ�����ͱ�����ͨ��������ж���޶� T extends Comparable & Serializable, �޶�������"&"�ָ�
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
 * һ�����һ������ Employee��Manager
 * 
 * Pair<Manager>����Pair<Employee>������
 * 
 * ͨ�������Pair<? extends Employee>, ��ʾ�κη���Pair���ͣ� �������Ͳ�����Employee�����࣬�� Pair<Manager>
 * 
 * 
 * 
 * ͨ����ĳ������޶�
 * 
 * ? super Manager, ���ͨ�������ΪManager�����г�����
 * 
 * 
 * ���޶�ͨ���
 * 
 * Pair<?>
 */