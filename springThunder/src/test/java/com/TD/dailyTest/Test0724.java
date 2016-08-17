package com.TD.dailyTest;

public class Test0724 {

  private static String getTempResult() {
    StringBuffer buffer = new StringBuffer();
    buffer.append(randomString("PRICE"));
    buffer.append("##");
    buffer.append(randomString("DTYPE"));
    buffer.append("##");
    buffer.append(randomString("TX"));
    return buffer.toString();
  }


  private static String randomString(String type) {
    java.util.Random random = new java.util.Random();
    int result = random.nextInt(4);
    if (result == 0) {
      if (type.equals("DTYPE")) {
        return "手机";
      } else if (type.equals("PRICE")) {
        return "499以下";
      } else {
        return "美颜";
      }
    } else if (result == 1) {
      if (type.equals("DTYPE")) {
        return "平板";
      } else if (type.equals("PRICE")) {
        return "2000-3999";
      } else {
        return "老人";
      }
    } else {
      if (type.equals("DTYPE")) {
        return "智能";
      } else if (type.equals("PRICE")) {
        return "1000-1999";
      } else {
        return "音乐";
      }
    }
  }
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(getTempResult());
    }
  }
}
