package com.yu.thread.thingInJava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author ziyu.wei
 * 2015��3��28�� ����10:11:30
 * 
 * �����ϣ���ʹ��synchronized�ؼ���ʱ�� ��ҪЩ���ٵĴ��룬�����û�������ֵĿ�����Ҳ�ή�ͣ����ͨ��ֻ���ڽ����������ʱ����ʹ����ʽ��Lock����
 * ���磬 ��synchronized�ؼ��ֲ��ܳ����Ż�ȡ�������ջ�ȡ����ʧ�ܣ����߳����Ż�ȡ��һ��ʱ�䣬Ȼ��������� Ҫʵ����Щ�������ʹ��conrrent���
 * 
 * ReentrantLock�����㳢���Ż�ȡ������δ��ȡ������������������Ѿ���ȡ��������� ����Ϳ��Ծ����뿪ȥִ������һЩ���飬�����ǵȴ�ֱ����������ͷ�
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
