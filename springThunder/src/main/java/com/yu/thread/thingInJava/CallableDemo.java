package com.yu.thread.thingInJava;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author ziyu.wei
 * 2015年3月27日 下午5:02:32
 * 
 * implements Callable , not Runnable. can get return value
 */
class TaskWithResult implements Callable<String> {
	
	private int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "result of TaskWithResult " + id ;
	}
	
}
public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i=0; i<10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		
		for (Future<String> rs: results) {
			try {
				System.out.println(rs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}

}
