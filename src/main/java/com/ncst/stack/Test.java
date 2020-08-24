package com.ncst.stack;

/**
 * @Date 2020/8/23 22:21
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        
    }
}
