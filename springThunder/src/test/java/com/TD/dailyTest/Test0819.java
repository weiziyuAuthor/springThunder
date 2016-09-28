package com.TD.dailyTest;

import java.math.BigDecimal;

import net.sf.json.JSONObject;

public class Test0819 {

  public static JSONObject putBasicData(float p, int c, int r) {
    JSONObject local = new JSONObject();
    if (Float.isNaN(p)) {
      // local.put("p", "NaN");
      local.put("p", 0);
      local.put("c", c);
      local.put("r", r);
      return local;
    }

    if (p == 0) {
      // local.put("p", "NaN");
      local.put("p", 0);
      local.put("c", 0);
      local.put("r", 0);
      return local;
    }

    BigDecimal fscale = new BigDecimal(p);
    p = fscale.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

    if (p != 0f && Float.compare(p, 0.01f) < 0) {
      local.put("p", 0.01f);
    } else if (p == 0f) {
      local.put("p", 0.0f);
    } else {
      local.put("p", p);
    }

    local.put("c", c);
    local.put("r", r);
    return local;
  }

  public static void main(String[] args) {

    int men = 169394668;
    int women = 79248944;

    // int men = 100;
    // int women = 200;

    JSONObject menTemp = putBasicData((float) men * 100 / (men + women), men, (men > women) ? 1 : 2);
    JSONObject womenTemp = putBasicData((float) women * 100 / (men + women), women, (men > women) ? 2 : 1);

    JSONObject sex = new JSONObject();
    sex.put("m", menTemp);
    sex.put("w", womenTemp);
    System.out.println(sex.toString());

  }

}
