package com.yu.thread.thingInJava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author ziyu.wei
 * 2015年3月28日 上午10:11:30
 * 
 * 大体上，当使用synchronized关键字时， 需要些更少的代码，并且用户错误出现的可能性也会降低，因此通常只有在解决特殊问题时，才使用显式的Lock对象。
 * 例如， 用synchronized关键字不能尝试着获取锁且最终获取锁会失败，或者尝试着获取锁一段时间，然后放弃它， 要实现这些，你必须使用conrrent类库
 * 
 * ReentrantLock允许你尝试着获取但最终未获取锁，这样如果其他人已经获取了这个锁， 那你就可以决定离开去执行其它一些事情，而不是等待直至这个锁被释放
 * 
 */
public class AttemptLocking {
	
	private ReentrantLock lock = new ReentrantLock();
	
	public void untimed() {
		boolean captured = lock.tryLock();
		
		try {
			System.out.println("tryLock(): " + captured);
			//without catch
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}
	
	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		try {
			System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		final AttemptLocking al = new AttemptLocking();
		al.untimed();
		al.timed();
		
		//create a seprate task to grab the lock
		new Thread(){
			{setDaemon(true);}
			
			public void run(){
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		
		Thread.yield();
		al.untimed();
		al.timed();
	}

}
