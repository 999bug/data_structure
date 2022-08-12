package com.offer.listnode;

import com.offer.base.BaseUtils;
import com.offer.base.ListNode;

import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/10/16:37
 * @Description: 反转链表
 */
public class ReverseNode extends BaseUtils {

    public static void main(String[] args) {
        ListNode listNode = createListNode(5);
        System.out.println("listNode = " + listNode);
        ListNode listNode1 = recursion(listNode);
        System.out.println("listNode1 = " + listNode1);
    }

    /**
     * 双指针的形式反转链表
     */
    private static ListNode reverseListNode(ListNode listNode) {
        ListNode cur = listNode;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归反转链表
     */
    private static ListNode recursion(ListNode listNode) {
        if (Objects.isNull(listNode)) {
            return null;
        }
        return recursionReverseNode(listNode, null);
    }

    private static ListNode recursionReverseNode(ListNode listNode, ListNode pre) {
        if (listNode == null) {
            return pre;
        }

        ListNode tmp = recursionReverseNode(listNode.next, listNode);
        listNode.next = pre;
        return tmp;
    }
}
