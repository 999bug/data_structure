package com.ncst.heap;

/**
 * @Date 2020/9/12 21:07
 * @Author by LiShiYan
 * @Descaption
 */
public interface IHeap<E> {
    /**
     * @return 元素的数量
     */
    int size();

    /**
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 清空
     */
    void clear();

    /**
     * 添加元素
     *
     * @param element
     */
    void add(E element);

    /**
     * @return 获得堆顶元素
     */
    E get();

    /**
     * @return 删除堆顶元素
     */
    E remove();

    /**
     * @param element
     * @return 删除堆顶元素的同时插入一个新元素
     */
    E replace(E element);
}
