package com.leetcode;

import com.offer.base.ListNode;

/**
 * @Date 2020/9/14 11:45
 * @Author by LiShiYan
 * @Descaption https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class 剑指_Offer_24_反转链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseList(node1);
        while (node!=null){

            System.out.println(node.value);
            node=node.next;
        }
    }


    public static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode cur = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return cur;
    }

}
