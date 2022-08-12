package com.offer.listnode;


import com.offer.base.BaseUtils;
import com.offer.base.ListNode;

import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/10/15:30
 * @Description: 寻找链表中倒数第K个节点
 */
public class FindKthToTail extends BaseUtils {

    public static void main(String[] args) {
        ListNode listNode = createListNode(5);
        ListNode kthToTail = findKthToTail(listNode, 5);
        System.out.println("kthToTail" + kthToTail);

    }

    /**
     * 1 2 3 4 5
     * 思路：倒数第k个节点就是 n - k + 1,n是节点总数，
     *  让walk走 k-1 步，然后让 findKthTo 开始走，
     *  直到walk走到最后一位时，findKthTo 即倒数第K个节点
     * @param listNode 原始节点
     * @param k 倒数的哪个节点
     * @return 倒数第k个节点
     */
    private static ListNode findKthToTail(ListNode listNode, int k) {
        if (Objects.isNull(listNode) || k < 1) {
            return null;
        }
        ListNode walk = listNode;
        ListNode findKthTo = listNode;

        for (int i = 0; i < k - 1; i++) {
            if (Objects.nonNull(walk.next)) {
                walk = walk.next;
            } else {
                return null;
            }
        }
        while (Objects.nonNull(walk.next)) {
            walk = walk.next;
            findKthTo = findKthTo.next;
        }
        return findKthTo;
    }
}
