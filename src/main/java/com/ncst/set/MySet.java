package com.ncst.set;

import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2020/9/1 9:45
 * @Author by LiShiYan
 * @Descaption 使用双向链表实现集合
 */
public class MySet<E> implements ISet<E> {
    private List<E> list=new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public void add(E element) {
        int index = list.indexOf(element);
        if (index != -1) {
            list.set(index, element);
        }else {
            list.add(element);
        }
    }

    @Override
    public void remove(E element) {
        int index = list.indexOf(element);
        if (index != -1) {
            list.remove(element);
        }
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        int size=list.size();
        //如果是true 则中止遍历
        for (int i = 0; i < size; i++) {
            if (visitor.visit(list.get(i))){
                return;
            }
        }
    }
}
