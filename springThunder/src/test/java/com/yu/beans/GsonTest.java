package com.yu.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

  public static void main(String[] args) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");

    map.put("list", list);

    Gson gson = new Gson();
    String result = gson.toJson(map);
    System.out.println(result);

    Map<String, List<String>> _map = gson.fromJson(result, Map.class);
    System.out.println(_map.get("list"));

    Map<String, List<String>> _map1 =
        gson.fromJson(result, new TypeToken<Map<String, List<String>>>() {}.getType());
    System.out.println(_map.get("list"));
  }

}
