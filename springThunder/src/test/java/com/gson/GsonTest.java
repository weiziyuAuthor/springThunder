package com.gson;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

  // JsonObject ageJsonObject = new JsonObject();
  // Gson gson = new Gson();
  // JsonParser parser = new JsonParser();
  // ageJsonObject.add("key", parser.parse(gson.toJson(ageKeyList)));
  // ageJsonObject.add("value", parser.parse(gson.toJson(ageValueList)));
  // returnJsonObject.add("age", ageJsonObject);


  private static void addProperty() {
    JsonObject obj = new JsonObject();
    obj.addProperty("k", "one");
    obj.addProperty("v", 1);
    System.out.println(obj.toString());
  }
  private static void getJsonValue() {
    JsonObject parent = new JsonObject();

    JsonObject sub1 = new JsonObject();
    sub1.addProperty("a", 1);
    parent.add("sub", sub1);

    Gson gson = new Gson();
    System.out.println(gson.toJson(parent));

    JsonObject subObj = parent.getAsJsonObject("sub");

    // Element.elementName
    System.out.println("--- " + subObj.get("a").getAsInt());

    Map<String, Integer> map =
        gson.fromJson(subObj, new TypeToken<Map<String, Integer>>() {}.getType());
    System.out.println(gson.toJson(subObj) + "\t" + map.get("a"));


  }
  public static void main(String[] args) {
    JsonObject parent = new JsonObject();

    JsonObject sub1 = new JsonObject();
    sub1.add("sub1", new JsonObject());

    JsonObject sub2 = new JsonObject();
    sub2.add("sub2", new JsonObject());
    sub2.add("sub1Value", sub1);

    parent.add("1", sub1);
    parent.add("2", sub2);

    Gson gson = new Gson();
    System.out.println(gson.toJson(parent));

    // 遍历key
    for (Entry<String, JsonElement> entry : parent.entrySet()) {
      System.out.println(entry.getKey() + "\t" + entry.getValue());
    };

    getJsonValue();

    addProperty();
  }

}
