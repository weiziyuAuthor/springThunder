package com.yu;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


public class TestSplit {

  public static void main(String[] args) {

    String parentCodeConfigString = "329@珠宝手表#333@服饰鞋帽"; // 329@珠宝手表#333@服饰鞋帽

    Map<String, String> parentMap = new HashMap<String, String>();
    if (StringUtils.isNotBlank(parentCodeConfigString)) {
      String[] array = parentCodeConfigString.split("#");
      for (String string : array) {
        String[] each = string.split("@");
        parentMap.put(each[0], each[1]);
      }
    }
    System.out.println(parentMap);

    long l1 = 5;
    long l2 = 100;

    System.out.println(((float) l1 / l2));
  }

}
