package com.yu.thingingInJava.generic.boundary;

public class BasicBounds {

  public static void main(String[] args) {
    Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
    solid.color();
    solid.getY();
    solid.weight();

  }

}
