package com.ncst2.traceback;

/**
 * @Date 2020/11/1 22:36
 * @Author by LSY
 * @Description N 皇后问题 ，优化
 */
public class NQueen2 {

    /**
     * 存一个皇后的列号(在第几列)
     */
    private int[] queens;

    /**
     * 存放每一列是否有皇后
     */
    private boolean[] cols;

    /**
     * 从左上 到 右下的斜线，标记着某一对角线是否有皇后
     */
    private boolean[] leftTop;

    /**
     * 从右上 到 左下的斜线，标记着某一对角线是否有皇后
     */
    private boolean[] rightTop;

    /**
     * 存放有多少种方式
     */
    private int ways;

    public static void main(String[] args) {
        new NQueen2().placeQueen(8);

    }

    public void placeQueen(int n) {
        if (n < 1) {
            return;
        }
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println("ways = " + ways);
    }

    /**
     * 从第row 行开始摆放 皇后
     */
    private void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            int leftIdx = row - col + cols.length - 1;
            int rightIdx = row + col;

            if (cols[col]) {
                continue;
            }
            if (leftTop[leftIdx]) {
                continue;
            }
            if (rightTop[rightIdx]) {
                continue;
            }
            //剪枝 + 存储第cols[col] 存在皇后
            cols[col] = leftTop[leftIdx] = rightTop[rightIdx] = true;
            //递归
            place(row + 1);
            //回溯 将 cols[col] 的皇后去除掉，将斜线重新置为 false
            cols[col] = leftTop[leftIdx] = rightTop[rightIdx] = false;
        }

    }

    /**
     * 打印每一次皇后的分布图
     */
    private void show() {
        for (int row = 0; row < queens.length; row++) {
            for (int col = 0; col < queens.length; col++) {
                if (queens[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("===============");
    }
}
