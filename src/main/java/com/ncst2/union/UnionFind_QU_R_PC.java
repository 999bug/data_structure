package com.ncst2.union;

import java.util.Arrays;

/**
 * @Date 2020/9/28 22:36
 * @Author by LSY
 * @Description Quick Union - 基于rank的优化 - 路径 压缩(Path Compression)
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R {

    public UnionFind_QU_R_PC(int capacity) {
        super(capacity);

    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        //递归调用
        if (parents[v]!=v){
            parents[v]=find(parents[v]);
        }
        return  parents[v];
    }
}
