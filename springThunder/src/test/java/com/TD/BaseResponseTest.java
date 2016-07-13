package com.TD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;


public class BaseResponseTest {

  public static void main(String[] args) {
    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    Map<String, String> map = new HashMap<String, String>();
    map.put("a", "0");
    list.add(map);
    BaseResponse resp = new BaseResponse("1", "2", list);
    System.out.println(JSONObject.fromObject(resp).toString());
  }

}
