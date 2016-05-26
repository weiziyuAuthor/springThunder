package com.yu.thread.thingInJava;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author ziyu.wei
 * 2015��3��28�� ����1:58:38
 * 
 * [�̱߳��ش洢]
 * 
 * ��ֹ�����ڹ�����Դ�ϲ�����ͻ�ĵڶ��ַ�ʽ�Ǹ����Ա����Ĺ����̱߳��ش洢��һ���Զ������ƣ� ����Ϊʹ����ͬ�����Ĳ�ͬ�̶߳�������ͬ�Ĵ洢����ˣ�
 * �������5���̶߳�Ҫʹ�ñ���x����ʾ�Ķ������̱߳��ش洢�ͻ�����5������x�Ĳ�ͬ�Ĵ洢��
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
		return "#" + id +  ":��" + ThreadLocalVariableHolder.get(); 
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
