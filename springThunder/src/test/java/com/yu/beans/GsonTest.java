package com.yu.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// http://blog.csdn.net/qxs965266509/article/details/42774691
public class GsonTest {

  public static void main(String[] args) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    // Map<String, Object> map = new HashMap<String, Object>();

    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");

    map.put("list", list);
    // map.put("name", "ziyu.wei");

    Gson gson = new Gson();
    String result = gson.toJson(map);

    JSONObject obj = new JSONObject();
    System.out.println(map.toString());
    System.out.println(obj.fromObject(map).toString());
    System.out.println(result);

    Map<String, List<String>> _map = gson.fromJson(result, Map.class);
    System.out.println(_map.get("list"));

    Map<String, List<String>> _map1 =
        gson.fromJson(result, new TypeToken<Map<String, List<String>>>() {}.getType());
    System.out.println(_map.get("list"));
  }

}
