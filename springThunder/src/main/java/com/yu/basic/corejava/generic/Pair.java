package com.yu.basic.corejava.generic;

/**
 * 泛型类
 * 
 * @author ziyu.wei@tendcloud.com
 * 
 *         2015年12月12日 上午11:51:33
 */
public class Pair<T> {

  private T first;

  private T second;

  public Pair() {
    first = null;
    second = null;
  }

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public void setSecond(T second) {
    this.second = second;
  }


}
