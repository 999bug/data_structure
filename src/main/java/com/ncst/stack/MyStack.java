package com.ncst.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/8/23 22:12
 * @Author by LiShiYan
 * @Descaption
 */
public class MyStack<E> {
    private List<E> list = new ArrayList<>();

    public int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public E pop(){
      return   list.remove(list.size()-1);
    }
    public void push(E e) {
        list.add( e);
    }
    public E top(){
        return list.get(list.size()-1);
    }
}
