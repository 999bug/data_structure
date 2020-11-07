package com.ncst2.dynamic;

/**
 * @Date 2020/11/5 22:53
 * @Author by LSY
 * @Description 假设有 25 分、20 分、5 分、1 分的硬币，现要找给客户 41 分的零钱，如何办到硬币个数最少？
 */
public class CoinsCount {
    public static void main(String[] args) {
        System.out.println(new CoinsCount().coin6(19, new int[]{1,5, 20, 25}));
    }

    /**
     * 递推（自底向上）
     * 时间 空间复杂度 O（n）
     * 通用版
     * 解决找零钱 找不开的 BUG
     */
    public int coin6(int n, int[] faces) {
        if (n < 1 || faces == null || faces.length == 0) {
            return -1;
        }
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : faces) {
                //@(1) 当前零钱找不开
                if (i < face) {
                    continue;
                }
                //例如 n = 6 时 dp[ 1] = -1 所以 continue
                int v = dp[i - face];
                //dp[i - face] >= min 取代了
                //min = Math.min(dp[i - face], min);
                if (v < 0 || v >= min) {
                    continue;
                }
                min = v;
            }
            //如果  min == Integer.MAX_VALUE 代表了 客户所给的钱找不开， for 循环一直 continue ，没有进行 @(1) 循环
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

    /**
     * 递推（自底向上）
     * 时间 空间复杂度 O（n）
     * 通用版
     */
    public int coin5(int n, int[] faces) {
        if (n < 1 || faces == null || faces.length == 0) {
            return -1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : faces) {
                if (i < face) {
                    continue;
                }
                //i >= face
                min = Math.min(dp[i - face], min);
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

    /**
     * 递推（自底向上）
     * 时间 空间复杂度 O（n）
     * 打印出 需要 的 硬币
     */
    public int coin4(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n + 1];
        int[] faces = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1 && dp[i - 1] < min) {
                min = dp[i - 1];
                faces[i] = 1;
            }
            if (i >= 5 && dp[i - 5] < min) {
                min = dp[i - 5];
                faces[i] = 5;
            }
            if (i >= 20 && dp[i - 20] < min) {
                min = dp[i - 20];
                faces[i] = 20;
            }
            if (i >= 25 && dp[i - 25] < min) {
                min = dp[i - 25];
                faces[i] = 25;
            }
            dp[i] = min + 1;
            print(faces, i);
        }
        //print(faces, n);
        return dp[n];
    }

    private void print(int[] faces, int n) {
        System.out.print("[" + n + "] = ");
        while (n > 0) {
            System.out.print(faces[n] + " ");
            n -= faces[n];
        }
        System.out.println();
    }

    /**
     * 递推（自底向上）
     * 时间 空间复杂度 O（n）
     */
    public int coin3(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1];
            if (i >= 5) {
                min = Math.min(dp[i - 5], min);
            }
            if (i >= 20) {
                min = Math.min(dp[i - 20], min);
            }
            if (i >= 25) {
                min = Math.min(dp[i - 25], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 记忆化搜索(自顶向下)
     */
    public int coin2(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n + 1];
        int[] faces = {1, 5, 20, 25};
        for (int face : faces) {
            //如果 n < face 退出循环，因为会造成数组下标越界
            if (n < face) {
                break;
            }
            dp[face] = 1;
        }
        return coin2(n, dp);
    }

    public int coin2(int n, int[] dp) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (dp[n] == 0) {
            int min1 = Math.min(coin2(n - 25, dp), coin2(n - 20, dp));
            int min2 = Math.min(coin2(n - 5, dp), coin2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    /**
     * 暴力递归（自顶向下）
     */
    public int coin1(int n) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (n == 25 || n == 20 || n == 5 || n == 1) {
            return 1;
        }
        int min1 = Math.min(coin1(n - 25), coin1(n - 20));
        int min2 = Math.min(coin1(n - 5), coin1(n - 1));
        // + 1 的意思是 保存了一枚硬币
        return Math.min(min1, min2) + 1;
    }
}
