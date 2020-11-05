package com.ncst2.dynamic;

/**
 * @Date 2020/11/5 22:53
 * @Author by LSY
 * @Description 假设有 25 分、20 分、5 分、1 分的硬币，现要找给客户 41 分的零钱，如何办到硬币个数最少？
 */
public class CoinsCount {
    public static void main(String[] args) {
        System.out.println(new CoinsCount().coin(41));
    }

    public int coin(int n) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (n == 25 || n == 20 || n == 5 || n == 1) {
            return 1;
        }
        int min1 = Math.min(coin(n - 25), coin(n - 20));
        int min2 = Math.min(coin(n - 5), coin(n - 1));
        // + 1 的意思是 保存了一枚硬币
        return Math.min(min1, min2) + 1;
    }
}
