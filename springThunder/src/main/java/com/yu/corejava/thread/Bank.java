package com.yu.corejava.thread;


/**
 * 
 * @author ziyu.wei@tendcloud.com
 *
 *         2016年10月11日 下午3:12:04
 * 
 *         lock对象被创建仅仅是用来使用每个Java对象持有的锁
 */
public class Bank {

  public void transfer(int from, int to, int amount) {
    synchronized (lock) { // an ad-hoc lock
      accounts[from] -= amount;
      accounts[to] += amount;
    }
  }

  private double[] accounts;
  private Object lock = new Object();
}
