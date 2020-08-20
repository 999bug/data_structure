package com.leetcode;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    int res = 1;
    int mark = 1;
    private List<Integer> list ;

    public ProductOfNumbers() {
        list = new ArrayList();
    }

    public void add(int num) {
        if (num != 0) {
            list.add(num);
            mark++;
        } else {
            mark = 1;
            list.clear();
        }

    }

    public int getProduct(int k) {
        if (k >= mark){
            return 0;
        }
        int count = 0;
        res = 1;
        for (int i = list.size() - 1; count < k; i--) {
            int cur = (int) list.get(i);
            if (cur == 0){
                return 0;
            }
            res *= cur;
            count++;
        }
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

