package com.TD.dailyTest;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.google.gson.Gson;

public class Test0831 {

  public static void main(String[] args) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("null", "a");
    map.put("b", "t");

    Gson gson = new Gson();
    System.out.println(gson.toJson(map));

    System.out.println(JSONObject.fromObject(map).toString());
  }

}
