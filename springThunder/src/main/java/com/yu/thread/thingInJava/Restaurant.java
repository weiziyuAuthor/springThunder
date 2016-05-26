package com.yu.thread.thingInJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal{
	private final int orderNum;
	
	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}
	
	public String toString() {
		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable{
	
	private Restaurant restaurant;
	
	public WaitPerson(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this){
					while (restaurant.meal == null) {
						wait();
					}
					System.out.println("WaitPerson got " + restaurant.meal);
					synchronized(restaurant.chef) {
						restaurant.meal = null;
						restaurant.chef.notifyAll();
					}
					
				}
			}
		} catch (InterruptedException e) {
			System.out.println("waitPerson interrupt");
		}
	}
	
}

class Chef implements Runnable{
	private int count = 0;
	
	private Restaurant restaurant;
	
	public Chef(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while (restaurant.meal != null) {
						wait();
					}
				}
				if (++count == 10) {
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.println("Order up !");
				synchronized(restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("chef interrupt");
		}
	}
	
}

public class Restaurant {
	
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	
	public Restaurant(){
		exec.execute(chef);
		exec.execute(waitPerson);
	}
	public static void main(String[] args) {
		new Restaurant();
	}
}
