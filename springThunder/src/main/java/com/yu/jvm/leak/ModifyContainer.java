package com.yu.jvm.leak;

import java.util.HashSet;
import java.util.Set;

import com.yu.bean.Person;

public class ModifyContainer {

  public static void main(String[] args) {
    Set<Person> set = new HashSet<Person>();
    Person p1 = new Person("name1", "p1", 22);
    Person p2 = new Person("name2", "p2", 22);
    Person p3 = new Person("name3", "p3", 22);

    set.add(p1);
    set.add(p2);
    set.add(p3);

    System.out.println("number1: " + set.size());

    p3.setAge(25);

    set.remove(p3);

    set.add(p3);

    System.out.println("number2: " + set.size());
  }

}
