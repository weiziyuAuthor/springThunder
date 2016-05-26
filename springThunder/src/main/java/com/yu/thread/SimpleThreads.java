package com.yu.thread;

/**
 * Join()方法可以让一个线程等待另一个线程执行完成。若t是一个正在执行的Thread对象， t.join();  
 * 将会使当前线程暂停执行并等待t执行完成。重载的join()方法可以让开发者自定义等待周期。然而，和sleep()方法一样join()方法依赖于
 * 操作系统的时间处理机制，你不能假定join()方法将会精确的等待你所定义的时长。 如同sleep()方法，join()方法响应中断并在中断时抛出
 * InterruptedException。 
 * @author ziyu.wei
 *
 * 2015年8月11日 下午3:18:47
 */
public class SimpleThreads {

	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	
	private static class MessageLoop implements Runnable{

		@Override
		public void run() {
			String importantInfo[] = {"Mars", "Stone", "Alcome", "Eric"};
			
			try {
				for (int i=0; i<importantInfo.length; i++) {
					Thread.sleep(4000);
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		long patience = 1000 * 60 * 60;
		
		if (args.length > 0) {
			try {
				patience = Long.parseLong(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.out.println("Argument must be an integer");
				System.exit(1);
			}
		}
		
		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		
		threadMessage("Waiting for MessageLoop thread to finish");
		
		while (t.isAlive()) {
			threadMessage("Still waiting");
			t.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience)
					&& t.isAlive()) {
				threadMessage("Tired of waiting");
				t.interrupt();
				
				t.join();
			}
		}
		
		threadMessage("Finally!");
	}
}
