package com.TD.dailyTest;

import java.util.Map;

import com.google.gson.Gson;

public class Test1205 {

  public static void main(String[] args) {
    Gson gson = new Gson();

    // "{\"id\":\"123\", \"code\":\"aaa\"}"
    // String result = "{\"message\":\"sucess\",\"result\":\"wlI9gg\",\"code\":200}";
    String result = "{\"message\":\"sucess\",\"result\":{\"id\":\"123\", \"code\":\"aaa\"},\"code\":200}";
    Map map = gson.fromJson(result, Map.class);
    System.out.println(((Map) map.get("result")).get("id"));
  }

}
