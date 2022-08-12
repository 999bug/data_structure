package com.offer.listnode;

import com.offer.base.BaseUtils;
import com.offer.base.ListNode;

import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/11/14:35
 * @Description: 合并两个有序链表
 */
public class Merge2SortNode extends BaseUtils {

    public static void main(String[] args) {
        ListNode listNodeOdd = createListNodeOdd(5);
        ListNode listNodeEven = createListNodeEven(5);
        System.out.println("listNodeOdd = " + listNodeOdd);
        System.out.println("listNodeEven = " + listNodeEven);
        ListNode merge = doublePointSort(listNodeOdd, null);
        System.out.println("merge = " + merge);
    }

    /**
     * 双指针形式合并两个链表
     */
    private static ListNode doublePointSort(ListNode node1, ListNode node2) {
        if (Objects.isNull(node1)) {
            return node2;
        }
        if (Objects.isNull(node2)) {
            return node1;
        }

        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while (Objects.nonNull(node1) && Objects.nonNull(node2)) {
            if (node1.value < node2.value) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        head.next = Objects.isNull(node1) ? node2 : node1;
        return cur.next;
    }

    /**
     * 递归形式合并两个有序链表
     */
    private static ListNode merge(ListNode node1, ListNode node2) {
        if (Objects.isNull(node1)) {
            return node2;
        }
        if (Objects.isNull(node2)) {
            return node1;
        }
        ListNode mergeNode;
        if (node1.value < node2.value) {
            mergeNode = node1;
            mergeNode.next = merge(node1.next, node2);
        } else {
            mergeNode = node2;
            mergeNode.next = merge(node1, node2.next);
        }
        return mergeNode;
    }

}
