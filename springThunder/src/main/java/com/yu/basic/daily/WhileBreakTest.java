package com.yu.basic.daily;

public class WhileBreakTest {

  private static void test2() {
    int k = 0;
    while (k < 10) {
      System.out.println("abc");
      if (k == 5) {
        break;
        // return;
      }
      k++;
    }
    System.out.println("NBA");
  }

  private static void test() {

    if (1 == 1) {
      while (true) {
        for (int i = 0; i < 10; i++) {
          System.out.println(i);
          if (i == 5) {
            break;
          }
        }
      }
    }
    System.out.println("here");
  }


  private void test3() {

      while (true) {
      int swith = 0;
        for (int i = 0; i < 10; i++) {
        // System.out.println(i);
        swith = 8;
          if (i == 5) {
            break;
          }
        }

      if (swith == 8) {
        break;
      }
      }
    System.out.println("abc");
  }


  private void test4() {

    while (true) {
      int swith = 0;
      for (int i = 0; i < 10; i++) {
        // System.out.println(i);
        swith = 8;
        if (i == 5) {
          return;
        }
      }

      if (swith == 8) {
        break;
      }
    }
    System.out.println("abc");
  }

  public static void main(String[] args) {
    WhileBreakTest whileBreakTest = new WhileBreakTest();
    // whileBreakTest.test3();
    whileBreakTest.test4();
  }

}
