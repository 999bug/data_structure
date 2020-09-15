package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Date 2020/9/15 12:25
 * @Author by LiShiYan
 * @Descaption
 */
public class 剑指_Offer_35_复杂链表的复制 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }


    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;

        //复制结点值
        while (cur != null) {
            //先存储新创建的结点值
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //复制结点指向
        cur = head;
        while (cur != null) {
            //新节点next 指向同旧结点的next指向
            map.get(cur).next = map.get(cur.next);
            //新节点的random 指向 同旧结点的random 指向
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.random = node1;
        Node node = copyRandomList(node1);

        System.out.println("node");
        print(node);
        System.out.println("===========");
        node1.val=333333;
        System.out.println("node1");
        print(node1);
        System.out.println("newNode");
        print(node);
    }

    static void print(Node node) {
        while (node != null) {
            System.out.println("val:" + node.val + "_" + "random:" + node.random);
            node = node.next;
        }
    }
}

