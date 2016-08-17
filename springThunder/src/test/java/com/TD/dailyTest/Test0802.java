package com.TD.dailyTest;

import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Test0802 {

  private static void test() {
    String string = "[{\"name\":\"a\", \"value\":12},{\"name\":\"a1\", \"value\":12}]";
    Gson gson = new Gson();

    JsonArray array = gson.fromJson(string, JsonArray.class);
    Iterator iter = array.iterator();
    int total = 0;
    while (iter.hasNext()) {
      JsonObject json = (JsonObject) iter.next();
      total += json.get("value").getAsInt();
    }

    JsonArray returnJsonArray = new JsonArray();
    Iterator _iter = array.iterator();
    while (_iter.hasNext()) {
      JsonObject json = (JsonObject) _iter.next();
      JsonObject returnJsonObject = new JsonObject();
      returnJsonObject.addProperty("name", json.get("name").getAsString());
      returnJsonObject.addProperty("value", (float) json.get("value").getAsInt() / total);
      returnJsonArray.add(returnJsonObject);
    }

    System.out.println(total);
    System.out.println(returnJsonArray.toString());
  }

  public static void main(String[] args) {

    // "carrier":{"name":"中国移动","meter":{"p":68.64,"c":232,"r":1}}}
    String string = "{\"name\":\"中国移动\",\"meter\":{\"p\":68.64,\"c\":232,\"r\":1}}";
    Gson gson = new Gson();

    JsonObject carrierJson = gson.fromJson(string, JsonObject.class);
    System.out.println(carrierJson.get("name").getAsString());
    if (carrierJson != null) {
      JsonObject carrierJsonObject = new JsonObject();
      carrierJsonObject.addProperty("name", carrierJson.get("name").getAsString());
      carrierJsonObject.addProperty("value", carrierJson.get("meter").getAsJsonObject().get("c").getAsInt());
      System.out.println(carrierJsonObject.toString());
    }

    test();
  }


}
