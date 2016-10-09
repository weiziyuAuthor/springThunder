package com.yu.thingingInJava.generic.unboundedwildcard;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ziyu.wei@tendcloud.com
 * 
 *         2016年10月9日 上午11:04:21
 *
 *         List:持有任何Object类型的原生List
 *
 *         List<?>:具有某种特定类型的非原生List, 只是我们不知道那种类型是什么
 */
public class UnboundedWildcard {

  static Map map1;
  static Map<?, ?> map2;
  static Map<String, ?> map3;

  static void assign1(Map map) {
    map1 = map;
  }

  static void assign2(Map<?, ?> map) {
    map2 = map;
  }

  static void assign3(Map<String, ?> map) {
    map3 = map;
  }

  public static void main(String[] args) {
    assign1(new HashMap());
    assign2(new HashMap());
    assign3(new HashMap());

    assign1(new HashMap<String, Integer>());
    assign2(new HashMap<String, Integer>());
    assign3(new HashMap<String, Integer>());

  }

}
