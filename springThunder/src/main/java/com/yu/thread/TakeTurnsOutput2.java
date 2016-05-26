package com.yu.thread;

public class TakeTurnsOutput2 extends Thread {
	private static int num = 0;
	static TakeTurnsOutput2 t1, t2;
	static int i = 0;
	static int x;
	static String ss = new String();

	public TakeTurnsOutput2() {

	}

	public void run() {
		while(true) {
			synchronized (ss) {
				ss.notify();
				Print();
				try {
					ss.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void Print() {
		num++;
		String result = "";
		for (int k=0; k<=num; k++) {
			result += (num + "");
		}
		System.out.println(this.getName() + " " +result);

	}

	public static void main(String[] args) throws InterruptedException {
		t1 = new TakeTurnsOutput2();
		t1.start();
		t2 = new TakeTurnsOutput2();
		t2.start();
	}

}
