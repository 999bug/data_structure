package com.leetcode.linearList;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date 2020/8/24 17:22
 * @Author by LiShiYan
 * @Descaption 队列的最大值  leetcode 剑值offer_59
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class offer_59_队列的最大值 {
    public static void main(String[] args) {
        MaxQueue maxQueue=new MaxQueue();
        maxQueue.push_back(10);
        maxQueue.push_back(2);
        maxQueue.push_back(1);
        maxQueue.push_back(12);
        int i = maxQueue.max_value();
        System.out.println("i = " + i);
        System.out.println("maxQueue = " + maxQueue.pop_front());
    }
    static class MaxQueue {

        Queue<Integer> queue;
        /**
         * 使用双端队列
         */
        Deque<Integer> help;

        public MaxQueue() {
            queue = new LinkedList<>();

            //辅助队列
            help = new LinkedList<>();
        }

        /**
         * 若辅助队列为空，返回-1，不然就返回队首
         *
         * @return 最大元素
         */
        public int max_value() {
            if (help.isEmpty()) {
                return -1;
            }
            return help.peekFirst();
        }

        /**
         * 队列常规加入，辅助队列需要判断，加入的元素要满足辅助队列从大到小，
         * 比当前小的就要删除，然后加入自己的位置，注意点这里相同的也需要加入！
         *
         * @param value 添加元素
         */
        public void push_back(int value) {
            queue.offer(value);

            //辅助队列保持从大到小
            while (!help.isEmpty() && value > help.peekLast()) {
                help.removeLast();
            }
            help.addLast(value);
        }

        /**
         * 如果常规队列是空就返回-1，不然正常返回，辅助队列需要判断是否是最大值，是的话就要删除，但不影响相同最大值。
         *
         * @return 返回队列首元素
         */
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int e = queue.remove();
            if (e == help.peekFirst()) {
                help.removeFirst();
            }
            return e;
        }
    }

}
