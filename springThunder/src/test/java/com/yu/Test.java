package com.yu;

import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("a");
    System.out.println(list.size() + " " + list.toString());

    System.out.println("韦子宇".hashCode());
    System.out.println("韦子宇1".hashCode());
  }

}
