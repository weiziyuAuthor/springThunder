package com.yu.thingingInJava.generic.wildcard.pro;

import java.util.ArrayList;
import java.util.List;

import com.yu.thingingInJava.generic.wildcard.Apple;
import com.yu.thingingInJava.generic.wildcard.Fruit;

public class GenericWriting {

  static <T> void writeExact(List<T> list, T item) {
    list.add(item);
  }

  static List<Apple> apples = new ArrayList<Apple>();
  static List<Fruit> fruit = new ArrayList<Fruit>();

  static void f1() {
    writeExact(apples, new Apple());
    // thinking in java v4, 告知此方法不支持；java v7已支持此方法
    // writeExact(fruit, new Apple());
    System.out.println(apples.size() + "\t" + fruit.size());
  }


  static <T> void writeWithWildcard(List<? super T> list, T item) {
    list.add(item);
  }

  static void f2() {
    writeWithWildcard(apples, new Apple());
    writeWithWildcard(fruit, new Apple());
  }

  public static void main(String[] args) {

    f1();
    f2();
  }
}
