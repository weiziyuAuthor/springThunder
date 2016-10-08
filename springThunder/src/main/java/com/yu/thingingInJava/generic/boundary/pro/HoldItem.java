package com.yu.thingingInJava.generic.boundary.pro;

public class HoldItem<T> {

  T item;

  HoldItem(T item) {
    this.item = item;
  }

  T getItem() {
    return item;
  }

}
