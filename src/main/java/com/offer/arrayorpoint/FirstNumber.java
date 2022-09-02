package com.offer.arrayorpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lisy
 * @Date: 2022/09/02/9:24
 * @Description: 第一个只出现一次的字符
 */
public class FirstNumber {
    public static void main(String[] args) {

    }
    public char firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        char result = 0;
        for (char aChar : chars) {
            if (map.get(aChar) == 1) {
                result = aChar;
                break;
            }
        }
        return result;
    }
}
