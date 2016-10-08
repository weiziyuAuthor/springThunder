package com.yu.thingingInJava.generic.boundary.pro;

import java.awt.Color;

import com.yu.thingingInJava.generic.boundary.HasColor;

public class Color2<T extends HasColor> extends HoldItem<T> {

  Color2(T item) {
    super(item);
  }

  Color color() {
    return item.getColor();
  }
}
