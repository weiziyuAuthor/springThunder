package com.yu.thingingInJava.generic.boundary.pro;

import com.yu.thingingInJava.generic.boundary.Dimension;
import com.yu.thingingInJava.generic.boundary.HasColor;
import com.yu.thingingInJava.generic.boundary.Weight;

public class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {

  Solid2(T item) {
    super(item);
  }

  int weight() {
    return item.weight();
  }

}
