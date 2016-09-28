package com.TD.dailyTest;

public class Test0817 {

  public static void main(String[] args) {
    int leftTime = 30;
    // int processedNum = 1;
    int baseNum = 15;

    for (int i = 0; i <= 14; i++) {
      int processedNum = 1;
      processedNum = processedNum + i;
      float f = ((float) processedNum / baseNum);
      // int processedLeftTime = Float.valueOf(leftTime * ((float) processedNum /
      // baseNum)).intValue();
      int processedLeftTime = Float.valueOf(leftTime * (1 - ((float) processedNum / baseNum))).intValue();
      System.out.println(processedNum + "\t" + processedLeftTime + "\t" + f);
    }

  }

}
