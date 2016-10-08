package com.yu.thingingInJava.generic.boundary.pro;

import com.yu.thingingInJava.generic.boundary.Bounded;

public class InheritBounds {

  public static void main(String[] args) {
    Solid2<Bounded> solid2 = new Solid2<Bounded>(new Bounded());
    solid2.color();
    solid2.getY();
    solid2.weight();
  }

}
