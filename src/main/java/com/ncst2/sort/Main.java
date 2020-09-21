package com.ncst2.sort;

import com.ncst1.sort.MergeSort;
import com.ncst2.sort.cmp.BubbleSort;
import com.ncst2.sort.cmp.HeapSort;
import com.ncst2.sort.cmp.SelectSort;
import com.ncst2.utils.Asserts;
import com.ncst2.utils.Integers;

import java.util.Arrays;

/**
 * @Date 2020/9/21 22:47
 * @Author by LiShiYan
 * @Descaption
 */
public class Main {
    public static void main(String[] args) {
        int count = 10000;
        int min = 1;
        int max = 100000;
        Integer[] array = Integers.random(count, min, max);

        testSorts(array,
                new SelectSort(),
                new BubbleSort(),
                new HeapSort()

        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
           // Integers.println(array);
           // Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
