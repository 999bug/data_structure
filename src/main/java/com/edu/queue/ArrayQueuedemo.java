package com.edu.queue;

import java.util.Scanner;

public class ArrayQueuedemo {
    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入队列");
        char str = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中获取数据");
            System.out.println("h(head):查看队列头数据");
            str = sc.next().charAt(0);//接收一个字符
            switch (str) {
                case 's':
                    arrayQueue.showQueue();
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入数字");
                    int value = sc.nextInt();
                    arrayQueue.addQueue(value);

                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println(queue);
                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                case 'h':
                    try {
                        int i = arrayQueue.headQueue();
                        System.out.println(i);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                  default:break;

            }
        }
        System.out.println("exit");

    }

    static class ArrayQueue {
        private int maxsize;//表示数组的最大容量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;//该数据用于存放数据，模拟队列

        //创建队列的构造器
        public ArrayQueue(int arrmaxSize) {
            maxsize = arrmaxSize;
            arr = new int[maxsize];
            front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
            rear = -1;//指向队列尾部，指向队列尾的数据（即是指向队列尾的最后一个数据）
        }

        //判断队列是否满
        public boolean isFull() {
            return maxsize - 1 == rear;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return front == rear;
        }

        //添加数据到队列
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满，不能加入数据");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        //获取队列数据，出队列
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能获取数据");
            }
            front++;
            return arr[front];
        }

        //显示队列的所有数据
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列为空！");
                return;
            }
            for (int i : arr) {
                System.out.printf("%d\t", i);
            }
        }

        //显示队列的头数据
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空!");
            }
            return arr[front+1];
        }
    }
}
