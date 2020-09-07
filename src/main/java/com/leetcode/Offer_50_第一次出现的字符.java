package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date 2020/9/7 22:36
 * @Author by LiShiYan
 * @Descaption https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class Offer_50_第一次出现的字符 {
    public static void main(String[] args) {

    }
    class Solution {
        public char firstUniqChar(String s) {
            Map<Character,Boolean> map=new LinkedHashMap<>();
            char [] chars=s.toCharArray();
            //通过map K V 结构存储，当映射中存在此元素时，将V 置为false
            for(char c:chars){
                map.put(c,!map.containsKey(c));
            }
            //第二次遍历，如果映射中的 V 为true 则 返回
            for(Map.Entry<Character, Boolean> d : map.entrySet()){
                if(d.getValue()){
                    return d.getKey();
                }
            }
            return ' ';
        }
    }
}
