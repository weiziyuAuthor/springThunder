package com.yu.experience.td;

public class ExceptionTestMain {

  public static void main(String[] args) {
    try {
      ExceptionTestBizz.test();
    } catch (ExceptionTest e) {
      e.printStackTrace();
    }
  }

}
