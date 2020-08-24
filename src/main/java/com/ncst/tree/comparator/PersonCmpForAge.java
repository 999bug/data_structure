package com.ncst.tree.comparator;

import com.ncst.tree.pojo.Person;

import java.util.Comparator;

/**
 * @Date 2020/8/24 22:45
 * @Author by LiShiYan
 * @Descaption
 */
public class PersonCmpForAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
