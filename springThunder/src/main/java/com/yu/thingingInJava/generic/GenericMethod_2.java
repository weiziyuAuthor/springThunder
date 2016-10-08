package com.yu.thingingInJava.generic;

public class GenericMethod_2 {

  public <T> void f(T t) {
    System.out.println(t.getClass().getName());
  }

  public static void main(String[] args) {
    GenericMethod_2 gm = new GenericMethod_2();
    gm.f("");
    gm.f(1);
    gm.f(1.0);
    gm.f(1.0f);
    gm.f('c');
    gm.f(gm);
  }

}
