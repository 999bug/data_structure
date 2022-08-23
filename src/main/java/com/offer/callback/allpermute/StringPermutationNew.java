package com.offer.callback.allpermute;

import java.util.*;

/**
 * @Author: Lisy
 * @Date: 2022/08/18/9:54
 * @Description: 字符串的排列，输入一个字符串，打印出该字符串中字符的所有排列
 */
public class StringPermutationNew {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        String[] abcs = new StringPermutationNew().permutation("eaddbcc");
        System.out.println(System.currentTimeMillis()-l);
        System.out.println(Arrays.toString(abcs));
    }

    private final Set<String> lists = new HashSet<>();
    private final StringBuilder sb = new StringBuilder();

    public String[] permutation(String s) {
        if (s == null || s.length() <= 0) {
            return new String[]{};
        }
        boolean[] isUsed = new boolean[s.length()];
        dfs(0, s.toCharArray(), isUsed);
        return lists.toArray(new String[0]);
    }

    private void dfs(int x, char[] chars, boolean[] isUsed) {
        if (x == chars.length) {
            lists.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!isUsed[i]) {
                sb.append(chars[i]);
                isUsed[i] = true;
                dfs(x + 1, chars, isUsed);
                isUsed[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }



}
