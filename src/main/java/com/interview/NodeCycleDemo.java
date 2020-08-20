package com.interview;

/**
 * @Date 2020/5/23 10:53
 * @Author by hp
 * @Description 环形链表
 */
public class NodeCycleDemo {

    /**
     * 判断是否有环
     *
     * @param head 链表头节点
     * @return
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2.next != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                nodeLength(p1, p2);
                startCycle(head, p2);
                return true;
            }
        }
        return false;
    }

    /**
     * 环形链表的长度
     *
     * @param p1 每次移动1格
     * @param p2 每次移动2格
     * @return
     */
    public static void nodeLength(Node p1, Node p2) {
        int temp = 0;
        do {
            p2 = p2.next;
            temp++;
        }
        while (p1 != p2);
        System.out.println("环形链表长度 = " + temp);
    }

    /**
     * 入环节点
     *
     * @param p1 回到头结点每次移动一格
     * @param p2 每次移动一格
     *           p1 和p2再次相遇的位置就是入环节点
     */
    public static void startCycle(Node p1, Node p2) {
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

        }
        System.out.println("入环节点 = " + p2.data);
    }

    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;

        System.out.println("是否存在环形链表："+isCycle(node1));
    }
}
