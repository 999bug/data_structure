package com.offer.base;

/**
 * @Author: Lisy
 * @Date: 2022/08/10/10:04
 * @Description:
 */
public abstract class BaseUtils {



    protected static ListNode createListNode(int listNums) {
        ListNode head = new ListNode(1);
        ListNode first = head;
        for (int i = 2; i <= listNums; i++){
            ListNode newNode = new ListNode(i);
            first.next = newNode;
            first = newNode;
        }
        return head;
    }

    protected static ListNode createListNodeOdd(int nums) {
        // 1 3 5 7 9 11
        int listNums = nums + nums - 1;
        ListNode head = new ListNode(1);
        ListNode first = head;
        for (int i = 3; i <= listNums; i++){
            ListNode newNode = new ListNode(i);
            first.next = newNode;
            first = newNode;
            i++;
        }
        return head;
    }

    protected static ListNode createListNodeEven(int nums) {
        // 2 4 6 8 10
        int listNums = 10;
        ListNode head = new ListNode(2);
        ListNode first = head;
        for (int i = 4; i <= listNums; i++){
            ListNode newNode = new ListNode(i);
            first.next = newNode;
            first = newNode;
            i++;
        }
        return head;
    }

    /**
     * -------6----
     * ----3-----9
     * --1---5--7
     * ---2-4----8
     * @return
     */
    protected static TreeNode createTree() {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        //返回根节点
        return A;
    }
}
