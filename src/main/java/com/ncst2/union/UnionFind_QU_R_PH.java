package com.ncst2.union;

/**
 * @Date 2020/9/28 22:36
 * @Author by LSY
 * @Description Quick Union - 基于rank的优化 - 路径减半(Path Halving)
 */
public class UnionFind_QU_R_PH extends UnionFind_QU_R {

    public UnionFind_QU_R_PH(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            parents[v] = parents[parents[v]];
            //1-->2-->3-->4-->5-->6
            // 当 v-->1 时，执行完上条语句 parents[v]--> 3
            //parents[v]--> 3
            v = parents[v];
        }
        return v;
    }
}
