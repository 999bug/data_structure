package com.offer.callback.allpermute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Lisy
 * @Date: 2022/08/23/10:14
 * @Description: 全排列
 * <a href="https://leetcode.cn/problems/permutations/">...</a>
 */
public class AllPermuteNonCut {
    public static void main(String[] args) {
        int len = 10;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = i;
        }
        for (int e = 0; e < 10; e++) {
            long l = System.currentTimeMillis();
            List<List<Integer>> permute = new AllPermuteNonCut().permute(array);
            System.out.println("耗时:" + e + (System.currentTimeMillis() - l));
        }

//        System.out.println(permute);
    }

    private final List<List<Integer>> results = new ArrayList<>();
    private final List<Integer> output = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return Collections.emptyList();
        }
        Arrays.stream(nums).parallel().forEach(output::add);

        dfs(nums.length, 0);
        return results;

    }

    private void dfs(int nums, int first) {
        if (nums == first) {
            results.add(new ArrayList<>(output));
        }

        for (int i = first; i < nums; i++) {
            Collections.swap(output, first, i);
            dfs(nums, first + 1);
            Collections.swap(output, first, i);
        }
    }

}
