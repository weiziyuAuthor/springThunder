package com.yu.thread.thingInJava;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author ziyu.wei
 * 2015��3��28�� ����11:07:22
 * 
 * [ԭ����]
 * 
 * �Գ�������˵�����Ǻ��ٻ������ó��� �������漰���ܵ���ʱ�����Ǿʹ�������֮��
 * 
 */
public class AtomicIntegerTest implements Runnable {

	private AtomicInteger i = new AtomicInteger();
	
	public int getValue() {
		return i.get();
	}
	
	private void evenIncrement() {
		i.addAndGet(2);
	}
	
	@Override
	public void run() {
		while (true) {
			evenIncrement();
		}
	}
	
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("Aborting");
				System.exit(0);
			}
			
		}, 5000);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicIntegerTest ait = new AtomicIntegerTest();
		exec.execute(ait);
		while (true) {
			int val = ait.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}


}
