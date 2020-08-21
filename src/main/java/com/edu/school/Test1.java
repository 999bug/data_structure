package com.edu.school;

import java.util.Arrays;

/**
 * @Date 2020/5/18 18:37
 * @Author by hp
 * 顺序存储结构和链式存储结构实现如下序列顺序的改变
 * 改前： (a1,a2,…an-1,an,b1,b2,…bm-1,bm)
 * 改后： (b1,b2,…bm-1,bm, a1,a2,…an-1,an)
 */
public class Test1 {

    /**
     * Node节点
     */
    public static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    /**
     * 顺序存储结构
     * time : O(n)  space :O(n)
     * @param arr 原数组
     * @param m   前面的个数
     * @param n   后面的个数
     * @return
     */
    public static int[] arraySwap(int[] arr, int m, int n) {
        int[] newArr = new int[m + n];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[m + i];
        }
        int index = 0;
        for (int i = n; i < newArr.length; i++) {
            if (index < m) {
                newArr[i] = arr[index++];
            }
        }
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    /**
     * time : O(n)  space :O(1)
     *
     * @param root 根节点
     * @param m    前面的个数
     * @param n    后面的个数
     * @return 新的链表
     */
    public static Node linkedListSwap(Node root, int m, int n) {
        int count = m;
        Node cur = root;

        //!1的原因 剩余一个节点指向next 否则为null
        while (cur != null && m != 1) {
            m--;
            cur = cur.next;
        }
        Node head = cur.next;

        //中间断开 否则链表会形成环形链表
        cur.next = null;
        cur = head;
        while (n != 1) {
            n--;
            cur = cur.next;
        }
        cur.next = root;
        return head;
    }

    /**
     * 输出链表
     *
     * @param head
     */
    private static void printNode(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " > ");
            cur = cur.next;
        }
        System.out.println(" null ");
    }

    public static void main(String[] args) {
        //a数组 1,2,3,4 b数组5,6,7,8,9
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arraySwap(arr, 4, 5);

        //1>2>3>4>5  1 2 3 为链表1  4 > 5 为链表2
        /*Node node4 = new Node(5, null);
        Node node3 = new Node(4, node4);
        Node node2 = new Node(3, node3);
        Node node1 = new Node(2, node2);
        Node root = new Node(1, node1);
        Node head = linkedListSwap(root, 3, 2);
        printNode(head);*/
    }
}
