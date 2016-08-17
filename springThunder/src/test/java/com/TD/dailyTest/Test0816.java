package com.TD.dailyTest;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

public class Test0816 {

  public static void main(String[] args) {
    Map<Integer, String> map = new TreeMap<Integer, String>(new Comparator<Integer>() {
      @Override
      public int compare(Integer arg0, Integer arg1) {
        return arg1.compareTo(arg0);
      }
    });

    map.put(2, "b");
    map.put(3, "c");
    map.put(1, "a");
    map.put(4, "d");

    Gson gson = new Gson();
    System.out.println(gson.toJson(map));
  }

}
