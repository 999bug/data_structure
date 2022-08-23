package com.offer.callback.allpermute;

import java.util.*;

/**
 * @Author: Lisy
 * @Date: 2022/08/18/9:54
 * @Description:  字符串的排列，输入一个字符串，打印出该字符串中字符的所有排列
 */
public class StringPermutationOld {

    public static void main(String[] args) {
        String[] abcs = new StringPermutationOld().permutation("eaddbcc");
        System.out.println(Arrays.toString(abcs));
    }

    private final List<String> lists = new ArrayList<>();
    private char[] chars;

    public String[] permutation(String s) {
        if(s == null || s.length() <= 0) {
            return new String[]{};
        }

        chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(0);
        return lists.toArray(new String[0]);
    }

    private void dfs(int x) {
        if (x == chars.length - 1 ) {
            lists.add(String.valueOf(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(i, x);
            dfs(x + 1);
            // 恢复交换
            swap(i, x);
        }
    }

    private void swap(int source, int dest) {
        char tmp = chars[source];
        chars[source] = chars[dest];
        chars[dest] = tmp;
    }

}
