package com.offer.stack;

import java.util.Stack;

/**
 * @Author: Lisy
 * @Date: 2022/08/16/9:18
 * @Description: 包含min函数栈
 */
public class MinStack {

    public static void main(String[] args) {

    }

    /**
     * 数据栈
     */
    Stack<Integer> dataStack;
    /**
     * 辅助栈
     */
    Stack<Integer> tmpStack;

    public MinStack() {
        dataStack = new Stack<>();
        tmpStack = new Stack<>();
    }

    /**
     * 思路：使用两个栈存储数据，一个是数据栈一个是辅助栈
     * push：首先像数据栈中添加数据，如果辅助栈空或者辅助栈中的元素大于添加的元素，那么像辅助栈中添加元素
     * pop:首先弹出数据栈，如果辅助栈的栈顶元素与数据栈中弹出元素相等那么，弹出辅助栈元素
     * min：展示辅助栈中栈顶元素
     * top：展示数据栈中栈顶元素
     */
    public void push(int x) {
        dataStack.push(x);
        if (tmpStack.isEmpty() || tmpStack.peek() >= x) {
            tmpStack.push(x);
        }
    }

    public void pop() {
        if (dataStack.pop().equals(tmpStack.peek())) {
            tmpStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return tmpStack.peek();
    }
}
