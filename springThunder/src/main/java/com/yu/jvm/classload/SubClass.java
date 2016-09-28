package com.yu.jvm.classload;

public class SubClass extends SuperClass {

  static {
    System.out.println("SubClass init! ");
  }
}
