package com.yu.experience.td.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    Callable<Integer> myComputation = null;

    FutureTask<Integer> task = new FutureTask<Integer>(myComputation);

    Thread t = new Thread(task);
    t.start();

    Integer result = task.get();
  }


}
