package com.ncst2.union;

/**
 * @Date 2020/9/28 22:36
 * @Author by LSY
 * @Description Quick Union - 基于rank的优化 - 路径 分割 (Path Splitting)
 * 路径分裂 使每一个 结点 都指向 祖父节点
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R {

    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v!=parents[v]) {
            //1.保存v 的父节点
            int parent = parents[v];
            //2. v 的祖父节点 为parent 的父节点
            parents[v] = parents[parent];
            //将一开始 v 的父节点 加入循环 ，进入1 语句；
            v = parent;
        }
        return v;
    }
}
