package com.yu.bean;

public class Person {

  private String name;
  private String passwd;
  private int age;


  public Person(String name, String passwd, int age) {
    super();
    this.name = name;
    this.passwd = passwd;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
