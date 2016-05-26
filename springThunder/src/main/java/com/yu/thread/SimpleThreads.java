package com.yu.thread;

/**
 * Join()����������һ���̵߳ȴ���һ���߳�ִ����ɡ���t��һ������ִ�е�Thread���� t.join();  
 * ����ʹ��ǰ�߳���ִͣ�в��ȴ�tִ����ɡ����ص�join()���������ÿ������Զ���ȴ����ڡ�Ȼ������sleep()����һ��join()����������
 * ����ϵͳ��ʱ�䴦����ƣ��㲻�ܼٶ�join()�������ᾫȷ�ĵȴ����������ʱ���� ��ͬsleep()������join()������Ӧ�жϲ����ж�ʱ�׳�
 * InterruptedException�� 
 * @author ziyu.wei
 *
 * 2015��8��11�� ����3:18:47
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
