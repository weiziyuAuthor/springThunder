package com.yu.experience.td.callable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter base directory (e.g. /usr/local/jdk/src)");
    String directory = in.nextLine();
    System.out.print("Enter keyword (e.g. volatile)");
    String keyword = in.nextLine();

    MatchCounter counter = new MatchCounter(new File(directory), keyword);
    FutureTask task = new FutureTask<Integer>(counter);
    Thread t = new Thread(task);
    t.start();

    try {
      System.out.println(task.get() + " matching files");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

  }

}


class MatchCounter implements Callable<Integer> {

  private File directory;
  private String keyword;
  private int count;

  public MatchCounter(File directory, String keyword) {
    this.directory = directory;
    this.keyword = keyword;
  }

  @Override
  public Integer call() throws Exception {
    count = 0;

    File[] files = directory.listFiles();
    ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

    for (File file : files) {
      if (file.isDirectory()) {
        MatchCounter counter = new MatchCounter(file, keyword);
        FutureTask<Integer> task = new FutureTask<Integer>(counter);
        results.add(task);
        Thread t = new Thread(task);
        t.start();
      } else {
        if (search(file)) {
          count++;
        }
      }
    }

    for (Future<Integer> result : results) {
      try {
        count += result.get();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return count;
  }

  public boolean search(File file) {
    try {
      Scanner in = new Scanner(new FileInputStream(file));
      boolean found = false;
      while (!found && in.hasNextLine()) {
        String line = in.nextLine();
        if (line.contains(keyword)) {
          found = true;
        }
        in.close();
      }
      return found;
    } catch (FileNotFoundException e) {
      return false;
    }
  }
}