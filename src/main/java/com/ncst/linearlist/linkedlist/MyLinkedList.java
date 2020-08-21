package com.ncst.linearlist.linkedlist;

import com.ncst.linearlist.AbstractList;
import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @Date 2020/8/21 10:10
 * @Author by LiShiYan
 * @Descaption
 */
public class MyLinkedList<E> extends AbstractList<E> {
    Node<E> head;
    Node<E> next;

    @Override
    public void clear() {
        size = 0;
        head = null;
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

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        //如果删除头结点，把头结点返回
        Node<E> node = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> prev = node(index - 1);
            //删除的不是头结点，返回此节点
            node = prev.next;
            //删除结点前一个结点的下一个结点指针，指向当前结点的下一个结点
            prev.next = node.next;
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
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
            node= node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
