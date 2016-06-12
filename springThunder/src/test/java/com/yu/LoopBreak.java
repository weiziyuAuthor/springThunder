package com.yu;

public class LoopBreak {

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.println(i);
      if (i == 5) {
        break;
      }
    }
  }

}
