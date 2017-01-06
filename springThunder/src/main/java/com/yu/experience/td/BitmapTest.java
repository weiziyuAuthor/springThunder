package com.yu.experience.td;

import java.util.Iterator;

import com.talkingdata.bitmap.ExtBitmap;

public class BitmapTest {

  public static void main(String[] args) {
    String phone1 = "13412341234";
    String phone11 = "134123412341";
    String phone2 = "134123412342";

    ExtBitmap offsetIdBitMap1 = new ExtBitmap();
    offsetIdBitMap1.set(Long.valueOf(phone1));
    offsetIdBitMap1.set(Long.valueOf(phone11));

    System.out.println(offsetIdBitMap1.cardinality());

    ExtBitmap offsetIdBitMap2 = new ExtBitmap();
    offsetIdBitMap2.set(Long.valueOf(phone2));

    ExtBitmap result = offsetIdBitMap1.or(offsetIdBitMap2);

    Iterator iter = result.javaLongIterator();
    while (iter.hasNext()) {
      System.out.println("result: " + iter.next());
    }

    System.out.println(result.cardinality());
  }

}
