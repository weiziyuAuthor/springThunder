package com.yu.thingingInJava.generic.wildcard;


public class CovariantArray {

  public void nonCovariantGenerics() {
    // compile error: imcompatiable types
    // List<Fruit> list = new ArrayList<Apple>();
  }

  public static void main(String[] args) {
    Fruit[] fruit = new Apple[10];
    fruit[0] = new Apple();
    fruit[1] = new Jonathan();

    try {
      fruit[0] = new Fruit();
    } catch (Exception e) {
      e.printStackTrace();

      try {
        fruit[0] = new Orange();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }

}
