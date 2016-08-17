package com.yu;

import net.sf.json.JSONObject;

public class JSONObjectTest0707 {

  public static void main(String[] args) {

    JSONObject contentObj = new JSONObject();

    JSONObject object = new JSONObject();

    JSONObject obj1 = new JSONObject();
    obj1.put("19", "19Obj");

    JSONObject obj2 = new JSONObject();
    obj2.put("199", "199Obj");

    object.put("19", obj1);
    object.put("199", obj2);

    contentObj.put("age", object);
    System.out.println(contentObj.toString());

  }

}
