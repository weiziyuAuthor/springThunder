package com.yu.thread.thingInJava;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author ziyu.wei
 * 2015年3月30日 下午2:47:43
 * 
 * interrupting a blocked thread
 * 
 * SleepBlock是可中断的阻塞实例， 而IOBlocked和SynchronizedBlocked是不可中断的阻塞用例
 * 
 * I/O和synchronized块上的等待是不可中断的
 * 
 * 无论是I/O还是尝试调用synchronized方法，都不需要任何InterruptedException处理器
 * 
 */

class SleepBlocked implements Runnable{

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
		System.out.println("Exiting SleepBlocked.run()");
	}
	
}

class IOBlocked implements Runnable{

	private InputStream in;
	
	public IOBlocked (InputStream in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("wating for read():");
			in.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("interrupted from blocked I/O");
			} else {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IOBlocked run()");
	}
}

class SynchronizedBlocked implements Runnable{

	public synchronized void f() {
		while(true){
			Thread.yield();
		}
	}
	
	public SynchronizedBlocked() {
		new Thread(){
			public void run() {
				f();
			}
		}.start();
	}
	
	@Override
	public void run() {
		System.out.println("Trying to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()");
	}
	
}

public class Interrupting {

	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting " + r.getClass().getName());
		f.cancel(true); //interrupts if running
		System.out.println("Interrupt sent to " + r.getClass().getName());
	}
	
	public static void main(String[] args) throws Exception {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Abording with System.exit(0)");
		System.exit(0);
		
	}

}
