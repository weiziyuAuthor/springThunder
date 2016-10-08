package com.yu.thingingInJava.generic;

class Automobile {

}


public class Holder_1<T> {

  private T a;

  public Holder_1(T a) {
    this.a = a;
  }

  public void set(T a) {
    this.a = a;
  }

  public T get() {
    return a;
  }

  public static void main(String[] args) {

    Holder_1<Automobile> holder = new Holder_1<Automobile>(new Automobile());

    Automobile automobile = holder.get();
  }

}
