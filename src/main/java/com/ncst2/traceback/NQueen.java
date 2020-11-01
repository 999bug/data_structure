package com.ncst2.traceback;

/**
 * @Date 2020/11/1 22:36
 * @Author by LSY
 * @Description N 皇后问题
 */
public class NQueen {

    /**
     * 存一个皇后的列号(在第几列)
     */
    private int[] queens;

    /**
     * 存放有多少种方式
     */
    private int ways;

    public static void main(String[] args) {
        new NQueen().placeQueen(8);

    }

    public void placeQueen(int n) {
        if (n < 1) {
            return;
        }
        queens = new int[n];
        place(0);
        System.out.println("ways = " + ways);
    }

    /**
     * 从第row 行开始摆放 皇后
     */
    private void place(int row) {
        if (row == queens.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            if (isValid(row, col)) {
                //在第row 行第 col 列存放一个皇后
                queens[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 检查第row行第col列是否可以摆放皇后
     */
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }
            //row -i/col-queen[i]== -1|1
            if (row - i == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }

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
