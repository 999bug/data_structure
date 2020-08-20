package com.interview;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.Stack;

/**
 * @Date 2020/5/24 17:35
 * @Author by hp
 * @Description 使用栈实现队列
 * 原理使用2个栈，一个进栈，一个出栈
 */
public class StackRealizeQueue {
    /**
     * 出栈
     */
    private Stack<Integer> pushStack;
    /**
     * 进栈
     */
    private Stack<Integer> pullStack;

    StackRealizeQueue() {
        pushStack = new Stack<>();
        pullStack = new Stack<>();
    }

    /**
     * 入队
     *
     * @param num
     */
    public void enQueue(int num) {
        pullStack.push(num);
    }

    public int deQueue() {
        if (pushStack.isEmpty()) {
           if (pullStack.isEmpty()){
               return 0;
           }
           tranfer();
        }
        return pushStack.pop();
    }

    private void tranfer() {
        while (!pullStack.isEmpty()){
            pushStack.push(pullStack.pop());
        }
    }


}
