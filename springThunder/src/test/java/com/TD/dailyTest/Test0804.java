package com.TD.dailyTest;

import java.math.BigDecimal;

public class Test0804 {

  public static void main(String[] args) {
    String deviceInfo = "iPhone|iPhone 4s|4000及以上|手机|摄影手机，高端商务";
    String[] infos = deviceInfo.split("\\|");
    System.out.println(infos.length);


    float progressRate = (float) 3 * 100 / 10;

    float progressRate1 = (float) 3 / 10;


    BigDecimal fscale = new BigDecimal(progressRate);
    System.out.println(fscale.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());

    System.out.println(Float.valueOf(30 * progressRate1).intValue());
  }

}
