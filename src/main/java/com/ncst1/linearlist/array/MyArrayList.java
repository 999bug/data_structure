package com.ncst1.linearlist.array;


import com.ncst1.linearlist.AbstractList;

/**
 * @Date 2020/8/20 11:09
 * @Author by LiShiYan
 * @Descaption 手写ArrayList
 */
public class MyArrayList<E> extends AbstractList<E> {

    /**
     * 所有的元素
     */
    private E[] array;

    private static final int DEFFAUT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        capacity = Math.max(capacity, DEFFAUT_CAPACITY);
        array = (E[]) new Object[capacity];
    }

    public MyArrayList() {
        this(DEFFAUT_CAPACITY);
    }

    /**
     * 清空元素
     */
    @Override
    public void clear() {
        //将对象引用置为空
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        //返回旧的元素
        E old = array[index];
        //在index 位置上赋值
        array[index] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    /**
     * @param index 下标
     * @return 删除元素
     */
    @Override
    public E remove(int index) {
        checkIndex(index);

        E old = array[index];
        for (int i = index+1; i < size; i++) {
            array[i-1] = array[i ];
        }
        //如果是对象，把对象的引用置为空
        array[--size] = null;
        //缩容
        trim();
        return old;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        //当查看元素索引为空时，返回第一个空的索引
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        }
        //查看元素不为空时
        else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 缩容
     */
    private void trim() {
        int oldCapacity=array.length;
        int newCapacity=oldCapacity>>2;

        //如果容量大于 旧的容量 的 1/4 或者旧的容量小于 默认容量 直接返回
        if (size>newCapacity||oldCapacity<=DEFFAUT_CAPACITY){
            return;
        }

        E[] newArray=(E[])new Object[newCapacity];

        //复制数组
        if (size >= 0) {
            System.arraycopy(array, 0, newArray, 0, size);
        }
        array=newArray;
        System.out.println(oldCapacity + "缩容为" + newCapacity);
    }

    /**
     * 扩容
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = array.length;
        if (oldCapacity >= capacity) {
            return;
        }
        //新数组的容量为旧数组的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        //新的数组
        E[] newArray = (E[]) new Object[newCapacity];
        //将旧的数组赋值给新的数组
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        //将新的数组指向array
        array = newArray;
        System.out.println(oldCapacity + "扩容为：" + newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size:").append(size).append(", [");

        for (int i = 0; i < size; i++) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(array[i]);
        }
        builder.append("]");
        return builder.toString();
    }
}
