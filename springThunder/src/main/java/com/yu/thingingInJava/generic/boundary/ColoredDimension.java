package com.yu.thingingInJava.generic.boundary;

import java.awt.Color;

public class ColoredDimension<T extends Dimension & HasColor> {

  T item;

  ColoredDimension(T item) {
    this.item = item;
  }

  T getItem() {
    return item;
  }

  Color color() {
    return item.getColor();
  }

  int getX() {
    return item.x;
  }

  int getY() {
    return item.y;
  }

  int getZ() {
    return item.z;
  }

}
