package com.TD.dailyTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.google.gson.JsonObject;

public class Test0725 {

  public static float setFloatScale(float v, int scaleNum) {
    BigDecimal fscale = new BigDecimal(v);
    return fscale.setScale(scaleNum, BigDecimal.ROUND_HALF_UP).floatValue();
  }

  public static void main(String[] args) {

    System.out.println(setFloatScale(96.72000122070312f, 2));


    String s = "12|123|4";
    System.out.println(s.split("\\|").length);

    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    Map<String, String> map = new HashMap<String, String>();
    map.put("a", "1");
    map.put("b", "2");
    list.add(map);
    JSONObject obj = new JSONObject();
    obj.put("test", list);
    System.out.println(list.toString());
    // System.out.println(JSONArray.fromObject(list).toString());
    System.out.println(JSONObject.fromObject(obj).toString());

    JsonObject j = new JsonObject();
    j.addProperty("a", "123");
    System.out.println(j.toString());
  }

}
