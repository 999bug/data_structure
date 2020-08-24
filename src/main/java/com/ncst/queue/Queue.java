package com.ncst.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2020/8/24 10:23
 * @Author by LiShiYan
 * @Descaption  队列
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
