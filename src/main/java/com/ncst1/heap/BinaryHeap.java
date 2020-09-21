package com.ncst1.heap;


import com.ncst1.heap.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @Date 2020/9/12 21:10
 * @Author by LiShiYan
 * @Descaption
 */
@SuppressWarnings("unchecked")
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {

    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);

        //如果传入的数组为空，默认初始化
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            //深拷贝
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
            /*for (int i = 0; i < elements.length; i++) {
				this.elements[i] = elements[i];
			}*/
            heapify();
        }
    }

    /**
     * 批量建堆
     */
    private void heapify() {

        //自上而下的上溢
       /* for (int i = 1; i <size; i++) {
            siftUp(i);
        }*/
        //自下而上的上溢
        for (int i = (size >> 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public BinaryHeap(E[] elements) {
        this(elements, null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap() {
        this(null, null);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    /**
     * 让index 位置的元素上溢
     *
     * @param index
     */
    private void siftUp(int index) {
        E tmp = elements[index];

        while (index > 0) {
            //父节点： 2*i+1 --》为子节点位置
            int pIndex = (index - 1) >> 1;
            E parent = elements[pIndex];
            if (compare(tmp, parent) <= 0) {
                break;
            }
            //将父元素存储在index 位置
            elements[index] = parent;
            //重新赋值index ，index 上移 到parent 结点位置
            index = pIndex;
        }
        elements[index] = tmp;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    @Override
    public E remove() {
        emptyCheck();

        int index = --size;
        E root = elements[0];
        elements[0] = elements[index];

        elements[index] = null;
        siftDown(0);
        return root;
    }

    /**
     * 让index位置的元素下滤
     *
     * @param index
     */
    private void siftDown(int index) {
        //头结点，待调整的元素
        E element = elements[index];

        //第一个叶子节点的索引 half == 非叶子节点的数量
        int half = size >> 1;

        //必须保证index位置是非叶子节点，并且选择左右子树最大值进行比较
        while (index < half) {
            /*
                index 的结点有2 种情况
                    1. 只有左子节点
                    2.同时拥有左右子节点
             */
            //默认左节点进行比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];

            //右子节点
            int rightIndex = childIndex + 1;

            //选出左右子结点最大的那个
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
                //将右子节 赋值到左子节点
                childIndex = rightIndex;
                child = elements[childIndex];
            }

            //父节点 》 孩子结点 退出循环
            if (compare(element, child) >= 0) {
                break;
            }

            //父节点小于 孩子结点

            //将子节点存放到index 位置
            elements[index] = child;
            index = childIndex;
        }
        elements[index] = element;

    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;

            siftDown(0);
        }
        return root;
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }
}
