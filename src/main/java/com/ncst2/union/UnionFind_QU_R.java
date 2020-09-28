package com.ncst2.union;

import java.util.Arrays;

/**
 * @Date 2020/9/28 22:36
 * @Author by LSY
 * @Description Quick Union - 基于rank的优化
 */
public class UnionFind_QU_R extends UnionFind_QU {
    private int[] ranks;

    public UnionFind_QU_R(int capacity) {
        super(capacity);
        ranks = new int[capacity];
        Arrays.fill(ranks, 1);

        /*for (int i = 0; i < sizes.length; i++) {
            sizes[i]=1;
        }*/
    }

    /**
     * 将v1的根节点嫁接到v2的根节点上
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) {
            return;
        }
        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
            ranks[p2] += 1;
        }
    }
}
