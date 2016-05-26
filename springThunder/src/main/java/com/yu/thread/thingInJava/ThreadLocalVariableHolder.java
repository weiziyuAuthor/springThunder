package com.yu.thread.thingInJava;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author ziyu.wei
 * 2015年3月28日 下午1:58:38
 * 
 * [线程本地存储]
 * 
 * 防止任务在共享资源上产生冲突的第二种方式是根除对变量的共享。线程本地存储是一种自动化机制， 可以为使用相同变量的不同线程都创建不同的存储。因此，
 * 如果你有5个线程都要使用变量x所表示的对象，那线程本地存储就会生成5个用于x的不同的存储块
 *
 */
class Accessor implements Runnable{

	private final int id;
	
	public Accessor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	
	public String toString() {
		return "#" + id +  ":　" + ThreadLocalVariableHolder.get(); 
	}
	
}

public class ThreadLocalVariableHolder {
	
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
		private Random rand = new Random(47);
		protected synchronized Integer initialValue() {
			return rand.nextInt(10000);
		}
	};
	
	public static void increment() {
		value.set(value.get() + 1);
	}
	
	public static int get() {
		return value.get();
	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i=0; i<5; i++) {
			exec.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(3);
		exec.shutdownNow();
	}

}
