package com.ncst2.greddy;

import java.util.Arrays;

/**
 * @Date 2020/11/5 21:23
 * @Author by LSY
 * @Description 假设有 25 分、20 分、5 分、1 分的硬币，现要找给客户 41 分的零钱，如何办到硬币个数最少？
 */
public class CoinChange {
    public static void main(String[] args) {
       new CoinChange().coinChange(new int[]{25, 5, 1, 20}, 41);
       // new CoinChange().coinChange(new int[]{25, 5, 1, 10}, 41);
    }

    public void coinChange(int[] nums, int money) {
        //由小到大排列
        Arrays.sort(nums);
        int idx = nums.length - 1, coins = 0;

        while (idx >= 0){
            while (money >= nums[idx]){
                System.out.println(nums[idx]);
                money -= nums[idx];
                coins++;
            }
            idx--;
        }
        System.out.println(coins);
    }
}
