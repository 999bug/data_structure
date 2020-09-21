package com.ncst1.queue;

/**
 * @Date 2020/8/24 15:47
 * @Author by LiShiYan
 * @Descaption 循环队列
 */
public class CircleQueue<E> {
    private int front;
    private int size;
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (E element : elements) {
            element = null;
        }
        front = 0;
        size = 0;
    }

    public void enQueue(E element) {
        ensureCapacity(size+1);
        elements[index(size)] = element;
        size++;
    }

    public E deQueue() {
        E element = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return element;
    }

    public E front() {
        return elements[front];
    }

    private int index(int index) {
        //  return  (index+front)%elements.length
        //index 不会大于2倍 elements.length
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }


    /**
     * 保证要有capacity的容量
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        // 重置front
        front = 0;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capcacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
