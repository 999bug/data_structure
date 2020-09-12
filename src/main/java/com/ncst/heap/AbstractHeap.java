package com.ncst.heap;

import java.util.Comparator;

/**
 * @Date 2020/9/12 21:12
 * @Author by LiShiYan
 * @Descaption
 */
public abstract class AbstractHeap<E> implements IHeap<E> {
    protected int size;
    protected Comparator<E> comparator;

    public AbstractHeap(Comparator<E> comparator) {
        this.comparator = comparator;

    }

    public AbstractHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2)
                : ((Comparable<E>) e1).compareTo(e2);
    }


}
