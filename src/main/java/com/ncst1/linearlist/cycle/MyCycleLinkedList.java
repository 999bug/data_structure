package com.ncst1.linearlist.cycle;

import com.ncst1.linearlist.AbstractList;
import com.ncst1.linearlist.linkedlist.Node;

/**
 * @Date 2020/8/21 10:10
 * @Author by LiShiYan
 * @Descaption 双向循环链表
 */
public class MyCycleLinkedList<E> extends AbstractList<E> {
    /**
     * 头结点
     */
    private Node<E> head;
    /**
     * 尾结点
     */
    private Node<E> last;

    private Node<E> current;

    @Override
    public void clear() {
        size = 0;
        head = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {

        //获取index 位置的node对象
        Node<E> node = node(index);
        //保存未修改之前的值
        E old = node.element;
        //赋新值
        node.element = element;
        //返回旧的值
        return old;
    }

    public void reset() {
        current = head;
    }

    /**
     * 返回当前结点的下一个结点的元素
     * @return
     */
    public E next() {
        if (current == null) {
            return null;
        }
        current = current.next;
        return current.element;
    }

    public E remove(){
        if (current==null){
            return null;
        }
        Node<E> next = current.next;

        //删除当前结点，返回结点的值
        E remove = remove(current);
        if (size==0){
            current=null;
        }else {
            current=next;
        }
        return remove;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        //在末尾添加
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, head);

            //链表添加的第一个元素
            if (oldLast == null) {
                head = last;
                //让头结点的前指针和后指针都指向自己
                head.next = head;
                head.pre = head;
            } else {
                //之前末尾元素的下一个指针指向新添加的这个元素
                oldLast.next = last;
                head.pre = last;
            }
        } else {
            //当前位置结点
            Node<E> next = node(index);
            Node<E> pre = next.pre;
            //新添加的这个元素的前指针指向pre 后指针指向cur
            Node<E> node = new Node<>(pre, element, next);
            next.pre = node;
            pre.next = node;

            //如果当前结点是头结点，则把新添加的这个元素赋值尾头结点
            if (next == head) { //index==0
                head = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return remove(node(index));
    }

    private E remove(Node<E> node) {
        if (size == 1) {
            head = null;
            last = null;
        } else {
            //当前结点
            Node<E> pre = node.pre;
            //当前结点的下一个结点
            Node<E> next = node.next;
            pre.next = next;
            next.pre = pre;
            //index==0
            if (node == head) {
                head = next;
            }
            //index==size-1
            if (node == last) {
                last = pre;
            }
        }
        size--;
        return node.element;
    }

    /**
     * 返回当前元素所在的索引位置，如果为空则返回第一个空值所在的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        //当前元素为空时，返回第一个空值所在的索引
        if (element == null) {
            Node<E> node = head;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = head;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取对应位置的元素
     *
     * @param index
     * @return
     */
    public Node<E> node(int index) {
        checkIndex(index);
        //在前半部分
        if (index < (size >> 1)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        //在后半部分
        else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size:").append(size).append(",[");
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
