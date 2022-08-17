package com.offer.listnode;

import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/17/11:15
 * @Description: 复制复杂链表
 */
public class CopyRandomList {

    /**
     * 思路：整体步骤分为三步，
     * 1.首先复制链表在原有基础上面复制出来一个克隆品
     * ---- A A' B B' C C' D D' E E' F F'
     * 2.将克隆品赋上随机指针
     * 3.拆分链表，奇数部分为原链表，偶数部分为复制出来的链表。
     * ----使用两个指针逐步向后遍历，
     * ----注意事项：循环结束时奇数链表的next指针置空，否则结果不对
     */
    public Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }

        Node cur = head;
        // 1、复制链表
        while (Objects.nonNull(cur)) {
            Node cloneNode = new Node(-1);
            cloneNode.val = cur.val;
            cloneNode.next = cur.next;
            cloneNode.random = null;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }
        // 2、给新节点赋随机指针
        cur = head;
        while (Objects.nonNull(cur)) {
            Node tmpNode = cur.next;
            if (Objects.nonNull(cur.random)) {
                tmpNode.random = cur.random.next;
            }
            cur = tmpNode.next;
        }
        // 3、拆分新节点
        cur = head.next;
        Node pre = head;
        Node result = head.next;
        while (Objects.nonNull(cur.next)) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        // 去掉最后一根连线
        pre.next = null;
        return result;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
