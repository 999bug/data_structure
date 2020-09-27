package com.ncst2.union;

/**
 * @Date 2020/9/27 22:15
 * @Author by LSY
 * @Description
 */
public abstract class UnionFind {
    protected int[] parents;

    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(" capacity must be >=1");
        }
        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    /**
     * 合并v1、v2所在的集合
     * 将 v1 所在的头结点 指向 v2 所在的头结点
     * @param v1 v1
     * @param v2 v2
     */
    public abstract void union(int v1, int v2);

    /**
     * @param v 要查找的点
     * @return v所属的集合（根节点）
     */
    public abstract int find(int v);

    /**
     * 检查v1、v2是否属于同一个集合
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /**
     * 边界检查
     */
    protected void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
