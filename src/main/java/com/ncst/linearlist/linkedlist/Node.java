package com.ncst.linearlist.linkedlist;

/**
 * @Date 2020/8/21 10:34
 * @Author by LiShiYan
 * @Descaption
 */
public class Node<E> {
    public E element;
    public Node<E> pre;
    public Node<E> next;



    public Node( Node<E> pre, E element,Node<E> next) {
        this.element = element;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (pre!=null){
            sb.append(pre.element);
        }else {
            sb.append("null");
        }

        sb.append("_").append(element).append("_");

        if (next!=null){
            sb.append(next.element);
        }
        else {
            sb.append("null");
        }
        return sb.toString();
    }
}
