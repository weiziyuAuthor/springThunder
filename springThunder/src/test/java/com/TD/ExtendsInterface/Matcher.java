package com.TD.ExtendsInterface;

public class Matcher<T extends ExtendsBase> {

  private T t;

  public Matcher(T t) {
    this.t = t;
  }

  T returnResult() {
    return t;
  }
}
