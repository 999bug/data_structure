package com.ncst.school.palindrome;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @Date 2020/5/11 10:16
 * @Author by 李石岩
 * 判断是否回文数
 */
public class PalindromeDemo {
    public static void main(String[] args) {
        String s = "abcdcbda";
        boolean b = validPalindrome(s);
        System.out.println(b);
    }

    public static boolean validPalindrome(String s) {
        if (s == null && s.length() == 0) {
            return false;
        }
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }

    }
