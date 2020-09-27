package com.ncst2.union;

import com.ncst2.utils.Asserts;

/**
 * @Date 2020/9/27 22:28
 * @Author by LSY
 * @Description
 */
public class TestUnion {
    static final int COUNT = 1000000;
    public static void main(String[] args) {
        UnionFind_QF uf=new UnionFind_QF(COUNT);

        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        Asserts.test(!uf.isSame(2, 7));

        uf.union(4, 6);

        Asserts.test(uf.isSame(2, 7));
    }
}
