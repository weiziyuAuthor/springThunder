package com.yu.thread;

public class TakeTurnsOutput1 extends Thread {
	private static int num = 0, n = 100;
	static TakeTurnsOutput1 t1, t2;
	static int i = 0;
	static int x;
	static String ss = new String();

	public TakeTurnsOutput1() {
		start();

	}

	public void run() {
		for (x = 0; x < 200; x++) {
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
//		synchronized (ss) {
//			ss.notifyAll();
//		}
	}

	public void Print() {
		if (i == 0) {
			i++;
			System.out.println(this.getName() + ":" + ++num);
		} else {
			i = (i + 1) % 2;
			System.out.println(this.getName() + ":" + n++);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		t1 = new TakeTurnsOutput1();
		t2 = new TakeTurnsOutput1();
	}

}
