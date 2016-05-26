package com.yu.basic.b_enum;

import java.io.Serializable;

/**
 *
 * @author ziyu.wei
 *
 *         枚举类型便于理解
 *
 * 
 */
public enum EnumResLevel implements Serializable {

  RES_LEVEL1("1", "1级简历"), RES_LEVEL2("2", "2级简历"), RES_LEVEL3("3", "3级简历"), RES_LEVEL4("4", "4级简历"), RES_LEVEL5(
      "5", "5级简历");

  private String code;

  private String name;

  private EnumResLevel(String code, String name) {
    this.code = code;
    this.name = name;
  }

  /**
   * 根据code取得枚举类
   * 
   * @param value
   * @return
   * @throws Exception
   */
  public static EnumResLevel getEnum(String value) throws Exception {
    EnumResLevel[] resLevels = EnumResLevel.values();
    for (EnumResLevel enumResLevel : resLevels) {
      if (enumResLevel.getCode().equals(value)) {
        return enumResLevel;
      }
    }
    throw new Exception("can't found correct enum");
  }

  /**
   * 根据枚举的code取得name
   * 
   * @param code
   * @return
   */
  public static String getNameByCode(String code) {
    EnumResLevel[] resLevels = EnumResLevel.values();
    for (EnumResLevel enumResLevel : resLevels) {
      if (enumResLevel.getCode().equals(code)) {
        return enumResLevel.getName();
      }
    }
    return null;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}
