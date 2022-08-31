package com.offer.arrayorpoint;

import com.ncst2.dynamic.Lis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Lisy
 * @Date: 2022/08/31/15:36
 * @Description: 获得从小到N之间的丑数，我们把能被 2、3、5整除的数字成为丑数
 */
public class GetUglyNumber {
    public static void main(String[] args) {
        int i = new GetUglyNumber().nthUglyNumber(11);
        System.out.println("i = " + i);
    }

    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return 1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            if (isUgly(i)) {
                list.add(i);
                System.out.print(i + " ");
            }
            if (list.size() == n) {
                break;
            }
        }
        return list.getLast();
    }

    private boolean isUgly(int num) {
        if (num == 0) {
            return Boolean.FALSE;
        }
        if (num == 1) {
            return Boolean.TRUE;
        }
        if (num % 2 == 0) {
            return Boolean.TRUE;
        }
        if (num % 3 == 0) {
            return Boolean.TRUE;
        }
        if (num % 5 == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
