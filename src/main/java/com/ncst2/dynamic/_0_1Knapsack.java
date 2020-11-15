package com.ncst2.dynamic;

/**
 * @Date 2020/11/15 22:36
 * @Author by LSY
 * @Description 0 1 背包问题
 * 有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 𝑥i 、价值是 𝑤i
 * 在保证总重量不超过 W 的前提下，选择某些物品装入背包，背包的最大总价值是多少？
 * 注意：每个物品只有 1 件，也就是每个物品只能选择 0 件或者 1 件
 */
public class _0_1Knapsack {
    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        int capacity = 10;
        System.out.println(select(values, weights, capacity));
    }
    /**
     * 状态定义：
     *      假设values 是价值数组，wights 是重量数组，编号为 K 的物品价值values[k],重量是weights[k],k∈ [0,n);
     *      假设dp(i,j)是最大承重 j、前 i 件礼物可选的最大总价值 i ∈ [1,n], j ∈ [1, w]
     * 动态转移方程：
     *      如果 j < weights[i - 1]，那么dp(i, j) = dp(i - 1, j);
     *      如果 j >= weights[i - 1]，那么dp(i, j) = max{dp(i - 1, j), dp(i - 1, values[i - 1] + j - weights[i - 1])};
     * 初始值：
     *      dp(i,0)、dp(0,j)均为 0
     * 返回值：
     *      dp(value,weight)
     */

    /**
     * 优化使用一维数组，从后向前遍历，保存上一行的 数据 不被覆盖
     * 优化遍历重量结束条件 ，减少循环次数
     */
    public static int select(int[] values, int[] weights, int capacity ) {
        if (values == null || values.length == 0) {
            return 0;
        }
        if (weights == null || weights.length == 0) {
            return 0;
        }
        //价值和重量必须对应，否则返回 0
        if (values.length != weights.length || capacity <= 0) {
            return 0;
        }

        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length ; i++) {
            //优化遍历重量结束条件 ，减少循环次数
           //最大承重刚好等于最后一件物品重量的时候，结束循环
            for (int j = capacity; j >= weights[i - 1]; j--) {
               /*
               删除掉这个代码，因为上面重量已经判断了当不满足时，直接退出循环
               if (j < weights[i - 1]) {
                    continue;
                }*/
                dp[j] = Math.max(
                        dp[j],
                        values[i - 1] + dp[j - weights[i - 1]]
                );
            }
        }
        return dp[capacity];
    }

    /**
     * 优化使用一维数组，从后向前遍历，保存上一行的 数据 不被覆盖
     */
    public static int select2(int[] values, int[] weights, int capacity ) {
        if (values == null || values.length == 0) {
            return 0;
        }
        if (weights == null || weights.length == 0) {
            return 0;
        }
        //价值和重量必须对应，否则返回 0
        if (values.length != weights.length || capacity <= 0) {
            return 0;
        }

        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length ; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (j < weights[i - 1]) {
                    continue;
                    //dp[j] = dp[j]
                }
                dp[j] = Math.max(
                        dp[j],
                        values[i - 1] + dp[j - weights[i - 1]]
                    );
            }
        }
        return dp[capacity];
    }

    public static int select1(int[] values, int[] weights, int capacity ) {
        if (values == null || values.length == 0) {
            return 0;
        }
        if (weights == null || weights.length == 0) {
            return 0;
        }
        //价值和重量必须对应，否则返回 0
        if (values.length != weights.length || capacity <= 0) {
            return 0;
        }

        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length ; i++) {
            for (int j = 1; j <= capacity ; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            values[i - 1] + dp[i - 1][j - weights[i - 1]]
                    );
                }
            }
        }
        return dp[values.length][capacity];
    }

}
