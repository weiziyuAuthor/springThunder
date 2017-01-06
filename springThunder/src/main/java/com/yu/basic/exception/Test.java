package com.yu.basic.exception;

public class Test {

  private static void testThrows(int a) throws Exception {
    try {
      int i = 5 / a;
    } catch (Exception e) {
      throw new Exception("error occurs", e);
    }
  }

  private static void test(int a) {
    try {
      int i = 5 / a;
    } catch (Exception e) {
      throw e;
    }
  }

  private static void testThrows2(int a) throws Exception {
    try {
      int i = 5 / a;
    } catch (Exception e) {
      throw e;
    }
  }

  public static void main(String[] args) {
    try {
      testThrows(0);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("------------------");
    try {
      testThrows2(0);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // test 放到最后， 必须要捕获， 不捕获， 后续流程中断
    System.out.println("------------------");
    test(0);

  }

}
