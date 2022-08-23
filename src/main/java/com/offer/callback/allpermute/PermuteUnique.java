package com.offer.callback.allpermute;


import java.util.*;

/**
 * @Author: Lisy
 * @Date: 2022/08/23/14:27
 * @Description: 全排列，带有剪枝功能
 */
public class PermuteUnique {


    private final List<List<Integer>> results = new ArrayList<>();
    private final Deque<Integer> paths = new ArrayDeque<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        dfs(nums, 0, new boolean[nums.length]);
        return results;
    }

    private void dfs(int[] nums, int depth, boolean[] isUsed) {
        if (nums.length == depth) {
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            // 上一层元素等于本层元素且上层元素没有被使用时剪枝，
            // 上一层元素被使用了，那么不需要剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) {
                continue;
            }
                paths.addLast(nums[i]);
                isUsed[i] = true;
                dfs(nums, depth + 1, isUsed);
                isUsed[i] = false;
                paths.removeLast();
        }
    }
}
