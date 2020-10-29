package com.interview.golden;


/**
 * @Date 2020/10/19 20:17
 * @Author by LSY
 * @Description 金矿问题
 */
public class GoldenProblem {
    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        GoldenProblem ge=new GoldenProblem();

        System.out.println("最优收益：" + getBestGoldenV3(w, p, g));
    }
    /**
     * @param w 工人数量
     * @param g 金矿含金量数组
     * @param p 金矿开采人数数组
     * @return 最优解 O(wn)
     */
    public static int getBestGoldenV3(int w, int[] p, int[] g) {
        //创建表格
        int[] results= new int[w + 1];
        //填充一维数组
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j>= 1; j--) {
               if (j >= p[i-1]){
                   results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
               }
            }
        }
        //返回最后1个格子的值
        return results[w];
    }


    /**
     * @param w 工人数量
     * @param g 金矿含金量数组
     * @param p 金矿开采人数数组
     * @return 最优解 O(wn)
     */
    public int getBestGoldenV2(int w, int[] p, int[] g) {
        //创建表格
        int[][] resultTable = new int[g.length+1][w + 1];
        //填充表格
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] =
                            Math.max(resultTable[i - 1][j],
                                    resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        //返回最后一个格子的值
        return resultTable[g.length][w];
    }


    /**
     * @param w 工人数量
     * @param n 金矿数量
     * @param g 金矿含金量数组
     * @param p 金矿开采人数数组
     * @return 最优解
     */
    public static int getBestGoldenV1(int w, int n, int[] p, int[] g) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (w < p[n - 1]) {
            return getBestGoldenV1(w, n - 1, p, g);
        }
        return Math.max(getBestGoldenV1(w, n - 1, p, g),
                getBestGoldenV1(w - p[n - 1], n - 1, p, g) + g[n - 1]);
    }
}
