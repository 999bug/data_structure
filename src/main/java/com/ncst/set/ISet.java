package com.ncst.set;

/**
 * @Date 2020/9/1 9:47
 * @Author by LiShiYan
 * @Descaption
 */
public interface ISet<E> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(E element);

    void add(E element);

    void remove(E element);

    void traversal(Visitor<E> visitor);

    abstract class Visitor<E> {
        boolean stop;

        public abstract boolean visit(E element);
    }

}
