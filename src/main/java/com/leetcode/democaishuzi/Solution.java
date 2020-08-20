package com.leetcode.democaishuzi;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] a=new int[123];
        int[] b=new int[123];
        int game = game(a, b);
        System.out.println(game);
    }
    public static  int game(int[] guess, int[] answer) {
        int count = 0;
        Map<Integer, Integer> guMap = new HashMap<>();
        Map<Integer, Integer> anMap = new HashMap<>();

        for (int i = 0; i < guess.length; i++) {
            guMap.put(guess[i], i);
        }

        for (int i = 0; i < answer.length; i++) {
            anMap.put(answer[i], i);
        }
        for (int i = 0; i < answer.length; i++) {
            if (anMap.get(i).equals(guMap.get(i))) {
                ++count;
            }
        }
        return count;
    }
}