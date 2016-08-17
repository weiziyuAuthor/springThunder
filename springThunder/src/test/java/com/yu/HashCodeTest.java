package com.yu;

public class HashCodeTest {

  public static long hash(String string) {
    long h = 1125899906842597L;
    int len = string.length();

    for (int i = 0; i < len; ++i) {
      h = 131L * h + string.charAt(i);
    }

    return h;
  }

  public static void main(String[] args) {
    System.out.println(hash("com.adobe.flashplayer"));
  }

}
