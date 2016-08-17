package com.yu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test0708 {

  public static void main(String[] args) {
    JSONObject object = new JSONObject();

    JSONArray array = new JSONArray();
    JSONObject objectArr = new JSONObject();
    objectArr.put("iPhone", "6s");
    array.add(objectArr);
    object.put("brandArray", array);

    Set<String> set = new HashSet<String>();
    set.add("set1");
    set.add("set2");
    object.put("model", set);

    Map<String, String> map = new HashMap<String, String>();
    map.put("mapK", "mapV");

    object.put("modelRate", map);

    System.out.println(object.toString());
  }

}
