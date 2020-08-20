package com.ncst.school.palindrome;

/**
 * @Date 2020/5/11 10:53
 * @Author by 李石岩
 */
public class PalindromeDemo1 {
    public static void main(String[] args) {
        int x = 1235321;
        Boolean pail = isPail(x);
        System.out.println("pail = " + pail);
    }

    public static Boolean isPail(Integer x) {
        int revertedNumber = 0;
        Boolean flag = false;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            flag = x == revertedNumber || x == revertedNumber / 10;
        }
        return flag;
    }
}
