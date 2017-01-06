package com.yu.thread;

public class ImmutableTest {

  private static final int a = 1;

  public static void main(String[] args) {

    final int b = 2;

    System.out.println(a);

    // b = 3;

    System.out.println(b);
  }
}
