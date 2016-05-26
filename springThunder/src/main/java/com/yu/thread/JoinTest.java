package com.yu.thread;

/**
 * 
 * @author ziyu.wei
 * 2015年3月26日 下午3:29:58
 * 
 * t.join() //使调用线程 t 在此之前执行完毕。
 */
public class JoinTest implements Runnable {

	public static int a = 0;
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			a = a + 1;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Runnable r = new JoinTest();
		Thread thread = new Thread(r);
		thread.start();
//		thread.join();
		
//		若没有调用 join方法
//		当主线程 main方法执行System.out.println(a);这条语句时，线程还没有真正开始运行，
//		或许正在为它分配资源准备运行。因为为线程分配资源需要时间，而main方法执行完t.start()方法后继续往下执行System.out.println(a);
//		这个时候得到的结果是a还没有被 改变的值0
		System.out.println(a);
	}
}
