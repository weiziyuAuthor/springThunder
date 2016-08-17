package com.TD;

public class T0808 {

  private static String transMins(int mins) {
    if (mins != 0) {
      int hours = mins / 60;
      int _mins = mins % 60;

      if (hours == 0) {
        return mins + "分钟";
      } else {
        return hours + "小时" + _mins + "分钟";
      }
    } else {
      return "已完成";
    }
  }

  public static void main(String[] args) {
    System.out.println(transMins(15));;
  }

}
