package com.yu.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

  public static String encrypt(String src) {
    MessageDigest md = null;
    String strDes = null;
    byte[] bt = src.getBytes();

    try {
      md = MessageDigest.getInstance("SHA-1");
      md.update(bt);
      strDes = byte2Hex(md.digest());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
    return strDes;
  }

  private static String byte2Hex(byte[] bts) {
    String des = "";
    String tmp = null;
    for (int i = 0; i < bts.length; i++) {
      tmp = Integer.toHexString(bts[i] & 0xFF);
      if (tmp.length() == 1) {
        des += "0";
      }
      des += tmp;
    }
    return des;
  }

  public static void main(String[] args) {
    String strSrc = "可以加密汉字.Oh,and english";
    System.out.println("Source String:" + strSrc);
    System.out.println("Encrypted String:");
    System.out.println("Use SHA:" + EncryptUtils.encrypt(strSrc).toUpperCase());
  }
}
