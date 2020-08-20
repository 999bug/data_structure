package com.interview;

import java.util.Stack;

/**
 * @Date 2020/5/23 12:13
 * @Author by hp
 * @Description 最小栈
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈操作
     *
     * @param num
     */
    public void push(int num) {
        //主栈中存入元素
        mainStack.push(num);

        //如果最小栈中元素为空或者栈顶元素大于num 则进栈
        if (minStack.empty() || minStack.peek() > num) {
            minStack.push(num);
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (mainStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取最小栈元素
     *
     * @return
     */
    public int getMin() {
        if (mainStack == null) {
            throw new RuntimeException("mainStack is empty!");
        }
        return mainStack.peek();
    }

}
