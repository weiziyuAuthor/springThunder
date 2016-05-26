package com.yu.thread.thingInJava;

/**
 * 
 * @author ziyu.wei
 * 2015年3月28日 下午12:49:55
 * 
 * [在其他对象上同步]
 * 
 * synchronized(this){...} , 在这种方式中，如果获得了synchronized块上的锁， 那么该对象其他的synchronized方法和临界区就不能被调用了
 * 
 * below example:
 * 	两个任务同时进入同一个对象，对象上的方法不在同一个锁上。
 * 	同步是相互独立的，两个方式在同时运行，任何一个方法都没有因为对另一个方法的同步而阻塞
 * 
 */
class DualSynch{
	private Object syncObject = new Object();
	
	public synchronized void f() {
		for (int i=0; i<50; i++) {
			System.out.println("f()");
			Thread.yield();
		}
	}
	
	public void g() {
		synchronized(syncObject) {
			for (int i=0; i<50; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
}
public class SyncObject {

	public static void main(String[] args) {
		final DualSynch ds = new DualSynch();
		new Thread() {
			public void run() {
				ds.f();
			}
		}.start();
		
		ds.g();
	}

}
