package com.yu.basic.daily;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.BeanUtils;

import com.yu.basic.daily.common.Teacher;

public class BeanCopyTest {

  public static void main(String[] args) {
    List<Teacher> list = new ArrayList<Teacher>();

    Teacher t1 = new Teacher();
    t1.setId(1);
    t1.setName("Tom");
    list.add(t1);

    Teacher t2 = new Teacher();
    t2.setId(2);
    t2.setName("Jerry");
    list.add(t2);

    List<Teacher> list2 = new ArrayList<Teacher>();

    BeanUtils.copyProperties(list, list2);

    System.out.println(JSONArray.fromObject(list2).toString());

  }

}
