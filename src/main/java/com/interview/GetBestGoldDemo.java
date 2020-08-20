package com.interview;

/**
 * @Date 2020/6/2 16:51
 * @Author by hp
 * @Description 获得金矿最优收益
 */
public class GetBestGoldDemo {
    /**
     * @param w 工人数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     * @return 获得金矿最优收益
     * 时间复杂度 O(nw)
     * 空间复杂度O(nw)
     */
    public int getBestGoldV1(int w, int[] p, int[] g) {
        //创建表格
        int[][] resultTable = new int[g.length + 1][w + 1];
        //填充表格
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] =
                            Math.max(resultTable[i - 1][j], resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        //返回最后1个格子的值
        return resultTable[g.length][w];
    }

    /**
     * @param w 工人数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     * @return 获得金矿最优收益
     * 时间复杂度 O(nw)
     * 空间复杂度O(n)
     */
    public int getBestGoldV2(int w, int[] p, int[] g) {
        int[] results = new int[w + 1];
        //填充一位数组
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        //返回最后1个格子的值
        return results[w];
    }

    /**
     * 递归实现获得金矿最优收益
     *
     * @param w 工人数量
     * @param n 可选金矿数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     */
    public int getBestGoldMining(int w, int n, int[] p, int[] g) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (w < p[n - 1]) {
            return getBestGoldMining(w, n - 1, p, g);
        }
        return Math.max(getBestGoldMining(w, n - 1, p, g), getBestGoldMining(w - p[n - 1], n - 1, p, g) + g[n - 1]);
    }

}
