package com.edu.hashtable;

/**
 * @Date 2020/6/4 17:24
 * @Author by hp
 * @Description 雇员表
 */
public class Emp {
    public Integer id;
    public String name;
    public Emp next;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
