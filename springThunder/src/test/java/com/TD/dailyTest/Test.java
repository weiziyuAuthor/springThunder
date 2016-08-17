package com.TD.dailyTest;


public class Test {

  public static void testJson() {
    String mapString = "{\"key\":\"name\"}";

    java.util.Random random = new java.util.Random();
    int result = random.nextInt(3);
    System.out.println("result: " + result);
  }

  public static void main(String[] args) {
    // (parentCodeSumcountMap.get(key) / indexCount) / tgi_denominator)

    float fm = 0.01045812f;
    // System.out.println(353508 / 23646871 / fm);
    System.out.println(((float) 353508 / 23646871) / fm);

    testJson();

    System.out.println("a1|a|a3|a4|a5".split("\\|").length);
  }

}
