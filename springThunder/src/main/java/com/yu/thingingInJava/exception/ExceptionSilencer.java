package com.yu.thingingInJava.exception;

/**
 *
 * @author ziyu.wei@tendcloud.com
 * 
 *         2016年9月28日 上午11:36:17
 *
 *         异常丢失: 从finally子句中返回
 */

public class ExceptionSilencer {

  public static void main(String[] args) {

    try {
      throw new RuntimeException();
    } catch (Exception e) {
      return;
    }
  }

}
