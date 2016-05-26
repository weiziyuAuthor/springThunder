package com.yu.thread.thingInJava;

/**
 * 
 * @author ziyu.wei
 * 2015��3��27�� ����6:17:28
 * 
 * sleep()�����п�����ָ����ʱ������ʱ���أ� ��Ҳ�п��ܱ��жϡ���catch�Ӿ��У�������isInterrupted()�ķ���ֵ��������жϡ�
 * ������һ���߳��ڸ��߳��ϵ���interrupt()ʱ�� �������߳��趨һ����־���������߳��Ѿ����жϡ�Ȼ�����쳣����ʱ�����������־������
 * ��catch()�Ӿ��У����쳣�����ʱ�������־����Ϊ��
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
