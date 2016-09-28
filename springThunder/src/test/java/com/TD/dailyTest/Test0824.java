package com.TD.dailyTest;

import net.sf.json.JSONArray;

public class Test0824 {

  public static void main(String[] args) {

    String activeContent = "null";
    JSONArray activeArray = JSONArray.fromObject(activeContent);
    System.out.println(activeArray == null);
  }

}
