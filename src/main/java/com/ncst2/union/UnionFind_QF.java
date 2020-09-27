package com.ncst2.union;

/**
 * @Date 2020/9/27 22:22
 * @Author by LSY
 * @Description QuickFind 实现并查集
 */
public class UnionFind_QF extends UnionFind {
    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    /**
     * 合并v1、v2所在的集合
     * 将 v1 所在的头结点 指向 v2 所在的头结点
     * @param v1 v1
     * @param v2 v2
     */
    @Override
    public void union(int v1, int v2) {
        int p1=find(v1);
        int p2=find(v2);
        if (p1==p2){
            return;
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i]==p1){
                //p1 的头结点为 p2 ，达成目的
                parents[i]=p2;
            }
        }
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }
}
