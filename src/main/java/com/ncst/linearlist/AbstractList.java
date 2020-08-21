package com.ncst.linearlist;

/**
 * @Date 2020/8/21 9:56
 * @Author by LiShiYan
 * @Descaption
 */
public abstract class AbstractList<E> implements MyList<E> {

    /**
     * 元素大小
     */
    protected int size;

    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 添加元素的边界值 是 > 而不是>=
     *
     * @param index
     */
    protected void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
