package com.yu.thread.thingInJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author ziyu.wei
 * 2015��4��1�� ����2:28:54
 * 
 * �߳�֮���Э��
 */
class Car{
	private boolean waxOn = false;
	
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}
	
	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() 
			throws InterruptedException {
		while (waxOn == false) {
			wait();
		}
	}
	
	public synchronized void waitForBuffing() 
			throws InterruptedException {
		while (waxOn == true) {
			wait();
		}
	}
}

class WaxOn implements Runnable{
	
	private Car car;
	
	public WaxOn(Car car) {
		this.car = car;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Wax on! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax on task! ");
	}
}

class WaxOff implements Runnable{
	
	private Car car;
	
	public WaxOff(Car car) {
		this.car = car;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForBuffing();
				System.out.println("wax off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax off task! ");
	}
	
}

public class WaxOMatic {

	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOn(car));
		exec.execute(new WaxOff(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
