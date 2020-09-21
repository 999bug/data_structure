package com.ncst1.set;

import com.ncst1.set.tree.RBTree;

import java.util.Comparator;

/**
 * @Date 2020/9/1 10:28
 * @Author by LiShiYan
 * @Descaption 红黑树实现 set 集合
 *              缺点 加入元素必须具备可比较性
 */
public class MyTreeSet<E> implements ISet<E> {
    private RBTree<E> tree ;

    public MyTreeSet() {
        this(null);
    }

    public MyTreeSet(Comparator<E> comparator) {
        tree = new RBTree<>(comparator);
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void clear() {
        tree.clear();
    }

    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    @Override
    public void add(E element) {
        tree.add(element);
    }

    @Override
    public void remove(E element) {
        tree.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        tree.inOrder(new com.ncst1.set.tree.Visitor<E>() {
            @Override
            public boolean visit(E element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
