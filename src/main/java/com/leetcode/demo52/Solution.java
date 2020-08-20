package com.leetcode.demo52;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(4);
        node6.next = node7;
        node7.next = node8;
        Solution s = new Solution();
        ListNode intersectionNode = s.getIntersectionNode(node1, node6);
        System.out.println("intersectionNode = " + intersectionNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }
}