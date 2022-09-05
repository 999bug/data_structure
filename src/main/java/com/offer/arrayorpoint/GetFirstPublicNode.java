package com.offer.arrayorpoint;

/**
 * @Author: Lisy
 * @Date: 2022/09/02/15:24
 * @Description: 获取第一个公共的节点
 */
public class GetFirstPublicNode {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
