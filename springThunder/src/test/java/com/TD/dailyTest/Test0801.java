package com.TD.dailyTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class Test0801 {

  public static void test1() {
    JsonObject j = new JsonObject();
    j.addProperty("1", "a");
    System.out.println(j.toString());
  }
  public static void test() {
    String jsonResult = "{\"appname\":\"YY-小米视频版\",\"hash\":-1233535283618068590,\"iconurl\":null}";
    JsonObject je = new JsonParser().parse(jsonResult).getAsJsonObject();

    System.out.println("000");
    JsonNull json = null;
    System.out.println(JsonNull.INSTANCE.equals(je.get("iconurl")));
    Map<String, Object> innerMap = new HashMap<String, Object>();
    System.out.println((je.get("iconurl") == null || "null".equals(je.get("iconurl"))));
    innerMap.put("icon", je.get("iconurl") == null ? "" : je.get("iconurl").getAsString());

    // appName = je.get("appname").getAsString();
    // if (map.containsKey(appName)) {
    // Map<String, Object> oldMap = map.get(appName);
    // oldMap.put("account", (Integer) oldMap.get("account") + countMap.get(hash));
    // map.put(appName, oldMap);
    // } else {
    // Map<String, Object> innerMap = new HashMap<String, Object>();
    // innerMap.put("icon", je.get("iconurl") == null ? "" : je.get("iconurl").getAsString());
    // innerMap.put("account", countMap.get(hash));
    //
    // map.put(appName, innerMap);
    // }
  }
  public static void main(String[] args) {

    String jsonResult = "[\"com.app.hero.ui\",\"com.apple.music\",\"tv.icntv.migu\"]";
    JsonParser parser = new JsonParser();
    JsonArray array = parser.parse(jsonResult).getAsJsonArray();


//    Map<String, Integer> map =
//        gson.fromJson(subObj, new TypeToken<Map<String, Integer>>() {}.getType());

    Gson gson = new Gson();
    List<String> list = gson.fromJson(array, new TypeToken<List<String>>() {}.getType());
    for (String each : list) {
      System.out.println(each);
    }

    test1();
    // if (array != null) {
    // Iterator iter = array.iterator();
    // while (iter.hasNext()) {
    // System.out.println((String) iter.next());
    // }
    // }
  }

}
