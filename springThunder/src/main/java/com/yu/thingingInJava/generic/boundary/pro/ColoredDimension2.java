package com.yu.thingingInJava.generic.boundary.pro;

import com.yu.thingingInJava.generic.boundary.Dimension;
import com.yu.thingingInJava.generic.boundary.HasColor;

public class ColoredDimension2<T extends Dimension & HasColor> extends Color2<T> {

  ColoredDimension2(T item) {
    super(item);
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
