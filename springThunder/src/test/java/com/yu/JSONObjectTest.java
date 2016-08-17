package com.yu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONObjectTest {

  public static void main(String[] args) {
    JSONObject obj = new JSONObject();
    obj.put("a", "123");
    obj.put("b", "2000");

    JSONObject object = new JSONObject();
    object.put("index", obj);

    String s = object.toString();
    System.out.println(s);

    JSONObject parsedObject = JSONObject.fromObject(s);
    JSONObject _obj = (JSONObject) parsedObject.get("index");
    _obj.put("c", "30000");

    object.put("index", _obj);
    System.out.println(_obj.toString());
    System.out.println(object.toString());

    // RETURN JSONOBJECT
    JSONObject labelJSONOBject = new JSONObject();
    JSONObject contentJSONObject = new JSONObject();
    contentJSONObject.put("total", 99);

    JSONObject marryObj = new JSONObject();
    marryObj.put("y", "23%");
    contentJSONObject.put("marry", marryObj);

    labelJSONOBject.put("expense", contentJSONObject);
    System.out.println(labelJSONOBject.toString());

    // TEST JSONOBJECT WITH MAP
    JSONObject json = new JSONObject();
    Map<String, String> jsonmap = new HashMap<String, String>();
    jsonmap.put("a", "a1");
    jsonmap.put("b", "b1");
    json.put("map", jsonmap);
    System.out.println(json.toString());

    JSONObject subJson = json.getJSONObject("map");
    Set<String> set3 = subJson.keySet();
    for (String s3 : set3) {
      System.out.println("s3: " + s3);
    }

    System.out.println("=========================");
    //
    JSONArray array = new JSONArray();
    JSONObject jObj = new JSONObject();
    JSONObject p1Obj = new JSONObject();
    p1Obj.put("p", 30);
    p1Obj.put("c", 30);

    jObj.put("a", p1Obj);
    array.add(jObj);

    JSONObject jObj1 = new JSONObject();
    JSONObject p2Obj = new JSONObject();
    p2Obj.put("p", 60);
    p2Obj.put("c", 60);

    jObj1.put("b", p2Obj);
    array.add(jObj1);

    Set<String> set = jObj.keySet();
    for (String str : set) {
      System.out.println(str);
    }

    Iterator iter = array.iterator();
    Map<Double, String> map = new HashMap<Double, String>();

    double max = 0;
    while (iter.hasNext()) {
      JSONObject obj1 = (JSONObject) iter.next();

      Set<String> keySet = obj1.keySet();
      for (String keyName : keySet) {
        System.out.println(keyName + " - " + obj1.get(keyName));
        JSONObject pObj = obj1.getJSONObject(keyName);
        double percent = pObj.getDouble("p");
        if (percent > max) {
          map.put(percent, keyName);
          max = percent;
        }
        System.out.println("percent: " + percent);
      }
    }
    System.out.println("map: " + map.toString());
    System.out.println("K: " + max + "\tV: " + map.get(max));
  }

}
