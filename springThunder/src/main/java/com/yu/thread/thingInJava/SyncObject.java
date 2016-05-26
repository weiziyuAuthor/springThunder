package com.yu.thread.thingInJava;

/**
 * 
 * @author ziyu.wei
 * 2015��3��28�� ����12:49:55
 * 
 * [������������ͬ��]
 * 
 * synchronized(this){...} , �����ַ�ʽ�У���������synchronized���ϵ����� ��ô�ö���������synchronized�������ٽ����Ͳ��ܱ�������
 * 
 * below example:
 * 	��������ͬʱ����ͬһ�����󣬶����ϵķ�������ͬһ�����ϡ�
 * 	ͬ�����໥�����ģ�������ʽ��ͬʱ���У��κ�һ��������û����Ϊ����һ��������ͬ��������
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
