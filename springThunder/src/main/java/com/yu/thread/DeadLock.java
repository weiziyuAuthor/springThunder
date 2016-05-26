package com.yu.thread;

/**
 * 当DeadLock运行后，两个线程极有可能阻塞，当它们尝试调用bowBack方法时。没有哪个阻塞会结束，因为每个线程都在等待另一个线程退出bow方法。
 * 
 * @author ziyu.wei
 *
 * 2015年8月11日 下午4:11:07
 */
public class DeadLock {
	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s" + "has bowed to me ! %n", this.name, bower.getName());
			bower.bowBack(this);
		}
		
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s" + "has bowed back to me ! %n", this.name, bower.getName());
		}
	}
	
	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		
		final Friend gaston = new Friend("Gaston");
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();
	}
}
