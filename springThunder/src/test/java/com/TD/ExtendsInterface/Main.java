package com.TD.ExtendsInterface;


public class Main {

  public static void main(String[] args) {

    Sub1 s1 = new Sub1();
    Matcher<Sub1> matcher = new Matcher<Sub1>(s1);
    System.out.println(matcher.returnResult());

  }

}
