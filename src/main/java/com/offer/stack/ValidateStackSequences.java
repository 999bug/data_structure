package com.offer.stack;

import java.util.Stack;

/**
 * @Author: Lisy
 * @Date: 2022/08/16/9:39
 * @Description: 栈的压入弹出序列
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 3, 5, 1, 2};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println("b = " + b);
    }

    /**
     * 思路：使用一个辅助栈，用来存储元素，逐一判断栈顶元素是否与逆序列相等，
     * 如果相等栈弹出元素，逆序列指针向后移动，继续判断
     * 中止循环条件：栈不为空且栈顶元素不等于逆序列中的元素
     * @param pushed {1,2,3,4,5}
     * @param popped {4,5,3,2,1}
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
