package com.yu.experience.td;

public class ExceptionTestBizz {

  public static void test() throws ExceptionTest {
    try {
      int i = 1 / 0;
    } catch (Exception e) {
      throw new ExceptionTest("error occurs", e);
    }
  }
}
