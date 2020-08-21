package com.ncst.linearlist.linkedlist;

import com.ncst.linearlist.AbstractList;

/**
 * @Date 2020/8/21 10:10
 * @Author by LiShiYan
 * @Descaption 双向链表
 */
public class MyLinkedList<E> extends AbstractList<E> {
    /**
     * 头结点
     */
    Node<E> head;
    /**
     * 尾结点
     */
    Node<E> last;

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

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        //在末尾添加
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            //链表添加的第一个元素
            if (oldLast == null) {
                head = last;
            } else {
                //之前末尾元素的下一个指针指向新添加的这个元素
                oldLast.next = last;
            }
        } else {
            //当前位置添加
            Node<E> cur = node(index);
            //当前位置的前一个位置
            Node<E> pre = cur.pre;
            //新添加的这个元素的前指针指向pre 后指针指向cur
            Node<E> node = new Node<>(pre, element, cur);
            //当前位置的前指针指向，新添加的元素位置
            cur.pre=node;

            //如果当前结点是头结点，则把新添加的这个元素赋值尾头结点
            if (pre==null){
                head=node;
            }else {
                //pre 的下一个指针指向新添加的结点
                pre.next=node;
            }

        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        //当前结点
        Node<E> node = node(index);
        //前一个结点
        Node<E> pre = node.pre;
        //下一个结点
        Node<E> next = node.next;

        if (pre == null) {
            head = next;
        } else {
            pre.next = next;
        }

        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
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
