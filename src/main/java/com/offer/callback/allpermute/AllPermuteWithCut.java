package com.offer.callback.allpermute;


import java.util.*;

/**
 * @Author: Lisy
 * @Date: 2022/08/23/14:27
 * @Description: 全排列，带有剪枝功能
 */
public class AllPermuteWithCut {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2};
        List<List<Integer>> permute = new AllPermuteWithCut().permute(array);
        System.out.println("permute = " + permute);
    }

    private final List<List<Integer>> results = new ArrayList<>();
    private final List<Integer> paths = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
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
            if (!isUsed[i]) {
                continue;
            }
            paths.add(nums[i]);
            isUsed[i] = true;
            dfs(nums, depth + 1, isUsed);
            isUsed[i] = false;
            paths.remove(paths.size() - 1);
        }
    }
}
