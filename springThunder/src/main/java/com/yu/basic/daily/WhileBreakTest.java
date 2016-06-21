package com.yu.basic.daily;

public class WhileBreakTest {

  public static void main(String[] args) {
    while (true) {
      for (int i = 0; i < 10; i++) {
        System.out.println(i);
        if (i == 5) {
          return;
        }
      }
    }
  }

}
