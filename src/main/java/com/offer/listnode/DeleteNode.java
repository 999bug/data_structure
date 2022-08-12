package com.offer.listnode;

import com.offer.base.BaseUtils;
import com.offer.base.ListNode;

import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/10/9:30
 * @Description: 删除链表中的结点
 */
public class DeleteNode extends BaseUtils {
    public static void main(String[] args) {
        ListNode listNode = createListNode(5);
        ListNode next = listNode.next.next.next.next.next;
        deleteNode(listNode, next);
    }

    public static void deleteNode(ListNode node, ListNode delNode) {
        if (Objects.nonNull(node) && Objects.nonNull(delNode)) {
            if (Objects.nonNull(delNode.next)) {
                // 非尾节点
                ListNode nextNode = delNode.next;
                delNode.value = nextNode.value;
                delNode.next = nextNode.next;
                nextNode.next = null;
            } else if (node == delNode) {
                // 链表只有一个节点，头节点也是尾节点
                node = null;
            } else {
                // 链表中有多个节点删除尾节点
                ListNode tmp = node;
                while (tmp.next != delNode) {
                    tmp = tmp.next;
                }
                tmp.next = null;

            }
        }
    }


}
