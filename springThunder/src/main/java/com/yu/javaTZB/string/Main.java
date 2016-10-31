package com.yu.javaTZB.string;

public class Main {
  // 编译时优化
  private static void test1() {
    String a = "a" + "b";
    String b = "ab";
    System.out.println(a == b);
  }

  private static String getA() {
    return "a";
  }

  private static void test2() {
    String a = "a";
    final String c = "a";

    String b = a + "b";
    String d = c + "b";
    String e = getA() + "b";

    String compare = "ab";
    System.out.println(b == compare);
    System.out.println(d == compare);
    System.out.println(e == compare);

  }

  public static void main(String[] args) {
    // test1();
    test2();
  }
}
