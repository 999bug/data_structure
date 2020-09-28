package com.ncst2.union;

/**
 * @Date 2020/9/27 22:22
 * @Author by LSY
 * @Description QuickUnion 实现并查集
 */
public class UnionFind_QU extends UnionFind {
    public UnionFind_QU(int capacity) {
        super(capacity);
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
        parents[p1] = p2;
    }

    /**
     * 通过parent链条不断地向上找，直到找到根节点
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }
}
