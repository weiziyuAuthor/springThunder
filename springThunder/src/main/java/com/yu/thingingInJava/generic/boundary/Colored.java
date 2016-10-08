package com.yu.thingingInJava.generic.boundary;

import java.awt.Color;

public class Colored<T extends HasColor> {

  T item;

  Colored(T item) {
    this.item = item;
  }

  T getItem() {
    return item;
  }

  Color color() {
    return item.getColor();
  }
}
