package com.ncst.array;





/**
 * @Date 2020/8/20 11:09
 * @Author by LiShiYan
 * @Descaption 手写ArrayList
 */
public class MyArrayList<E> {

    /**
     * 元素数量
     */
    private int size;
    /**
     * 所有的元素
     */
    private E[] array;

    private static final int DEFFAUT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

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
    public void clear() {
        //将对象引用置为空
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * 添加元素到尾部
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkIndexAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }


    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    public E seEt(int index, E element) {
        checkIndex(index);
        //返回旧的元素
        E old = array[index];
        //在index 位置上赋值
        array[index] = element;
        return old;
    }


    /**
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param index 下标
     * @return 删除元素
     */
    public E remove(int index) {
        checkIndex(index);

        E old = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        //如果是对象，把对象的引用置为空
        array[--size] = null;
        return old;
    }


    /**
     * @return 元素数量
     */
    public int size() {
        return size;
    }


    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
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
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 扩容
     */
    public void ensureCapacity(int capacity) {
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

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 添加元素的边界值 是 > 而不是>=
     *
     * @param index
     */
    private void checkIndexAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
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
