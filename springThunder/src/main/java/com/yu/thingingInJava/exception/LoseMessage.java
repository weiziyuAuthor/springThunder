package com.yu.thingingInJava.exception;

/**
 *
 * @author ziyu.wei@tendcloud.com
 * 
 *         2016年9月28日 下午12:04:14
 *
 *         缺憾：异常丢失
 */
class VeryImportantException extends Exception {

  @Override
  public String toString() {
    return "A very important exception!";
  }
}


class HoHumException extends Exception {
  @Override
  public String toString() {
    return "A trivial exception!";
  }
}


public class LoseMessage {
  void f() throws VeryImportantException {
    throw new VeryImportantException();
  }

  void dispose() throws HoHumException {
    throw new HoHumException();
  }

  public static void main(String[] args) {
    try {
      LoseMessage lm = new LoseMessage();
      try {
        lm.f();
      } finally {
        lm.dispose();
      }
    } catch (Exception e) {
      System.out.println(e);
    }


  }

}
