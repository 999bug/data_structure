package com.offer.callback;

import com.ncst2.dynamic.Lis;

import java.util.*;

/**
 * @Author: Lisy
 * @Date: 2022/08/24/10:23
 * @Description:
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        String str = "101023";
        List<String> list = new RestoreIpAddresses().restoreIpAddresses(str);
        if (list.isEmpty()) {
            System.out.println("error");
        } else {

            list.forEach(System.out::println);
        }
    }

    private final List<String> results = new LinkedList<>();
    private final Deque<String> paths = new ArrayDeque<>(4);

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len < 4 || len > 12) {
            return Collections.emptyList();
        }

        dfs(s, 0, 4);
        return results;
    }

    private void dfs(String s, int begin, int residue) {
        int length = s.length();
        if (begin == length) {
            if (residue == 0) {
                results.add(String.join(".", paths));
                return;
            }
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= length) {
                break;
            }
            // 判断剩下的字符串是否够组成网段
            if ((residue - 1) * 3 < length - i - 1) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                paths.addLast(s.substring(begin, i + 1));
                dfs(s, i + 1, residue - 1);
                paths.removeLast();
            }
        }

    }

    /**
     * 判断该区间内的网段是否符合要求
     */
    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        // 当前字符串以0开头且长度大于1需要剪枝
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        // 将截取的字符串转换为数字并判断是否在0-255区间内
        int res = Integer.parseInt(s.substring(left, right + 1));
        //判断截取到的数字是否符合
        return res >= 0 && res <= 255;
    }
}
