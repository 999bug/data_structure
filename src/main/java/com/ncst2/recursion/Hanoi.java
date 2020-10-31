package com.ncst2.recursion;

/**
 * @Date 2020/10/31 20:57
 * @Author by LSY
 * @Description 汉诺塔
 */
public class Hanoi {
    public static void main(String[] args) {
        int n = 3;
        new Hanoi().hanoi(n, "A", "B", "C");
    }

    /**
     * @param n  有几个盘子
     * @param p2 中间的柱子
     */
    public void hanoi(int n, String p1, String p2, String p3) {
        if (n <= 1) {
            move(n, p1, p3);
            return;
        }
        //将 n-1 个盘子从 A 挪到 B
        hanoi(n - 1, p1, p3, p2);
        //将 编号为n的盘子从 A 挪到 C
        move(n, p1, p3);
        //将 n-1 个盘子从 B 挪到 C
        hanoi(n - 1, p2, p1, p3);

    }

    private void move(int n, String from, String to) {
        System.out.println(n + "号" + "盘子" + "从" + from + "挪动到" + to);
    }
}
