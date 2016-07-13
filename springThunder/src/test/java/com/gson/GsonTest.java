package com.gson;

import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GsonTest {

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

    for (Entry<String, JsonElement> entry : parent.entrySet()) {
      System.out.println(entry.getKey() + "\t" + entry.getValue());
    };
  }

}
