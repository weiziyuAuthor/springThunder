package com.yu.thingingInJava.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariant {

  public static void main(String[] args) {
    List<? extends Fruit> list = new ArrayList<Apple>();
    // compile error: can't add any type of object
    // list.add(new Apple());
    // list.add(new Fruit());
    // list.add(new Object());
    list.add(null);
  }

}
