package com.yu.thingingInJava.generic.wildcard.pro;

import java.util.List;

import com.yu.thingingInJava.generic.wildcard.Apple;
import com.yu.thingingInJava.generic.wildcard.Jonathan;


public class SuperTypeWildcards {

  /**
   * Apple 是下界
   *
   * @param apples
   */
  static void writeTo(List<? super Apple> apples) {
    apples.add(new Apple());
    apples.add(new Jonathan());
    // apples.add(new Fruit());
  }

  public static void main(String[] args) {
  }

}
