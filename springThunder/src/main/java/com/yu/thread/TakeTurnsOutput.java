package com.yu.thread;

public class TakeTurnsOutput {
	
	private int i = 0;
	
	private Object object = new Object();
	
	class A implements Runnable{

		@Override
		public void run() {
			synchronized(object) {
				print();
				this.notifyAll();
				try {
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class B implements Runnable{

		@Override
		public void run() {
			synchronized(object) {
				print();
				this.notifyAll();
				try {
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private synchronized void print() {
		i++;
		String result = "";
		for (int k=0; k<=i; k++) {
			result += i;
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Thread threadA = new Thread(new TakeTurnsOutput().new A());
		Thread threadB = new Thread(new TakeTurnsOutput().new B());
		threadA.start();
		threadB.start();
	}

}
