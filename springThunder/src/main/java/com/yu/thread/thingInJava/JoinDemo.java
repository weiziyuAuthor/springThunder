package com.yu.thread.thingInJava;

/**
 * 
 * @author ziyu.wei
 * 2015年3月27日 下午6:17:28
 * 
 * sleep()方法有可能在指定的时间期满时返回， 但也有可能被中断。在catch子句中，将根据isInterrupted()的返回值报告这个中断。
 * 当另外一个线程在该线程上调用interrupt()时， 将给该线程设定一个标志，表明该线程已经被中断。然而，异常捕获时将清理这个标志，所以
 * 在catch()子句中，在异常捕获的时候这个标志总是为假
 */
class Sleeper extends Thread{
	private int duration;
	
	public Sleeper(String name, int duration) {
		super(name);
		this.duration = duration;
		start();
	}
	
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread{
	private Sleeper sleeper;
	
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}
public class JoinDemo {

	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500);
		Sleeper grumpy = new Sleeper("grumpy", 1500);
		
		Joiner dopey = new Joiner("Dopey", sleepy);
		Joiner doc = new Joiner("Doc", grumpy);

//		OUTPUT		
//		Sleepy has awakened
//		grumpy has awakened
//		Dopey join completed
//		Doc join completed
		
		
//		grumpy.interrupt();
//		OUTPUT
//		grumpy was interrupted. isInterrupted(): false
//		Doc join completed
//		Sleepy has awakened
//		Dopey join completed
	}

}
