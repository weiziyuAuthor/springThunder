package com.yu.basis.corejava.generic;

/**
 * ������
 * 
 * @author ziyu.wei@tendcloud.com
 * 
 *         2015��12��12�� ����11:51:33
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
