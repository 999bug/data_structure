package com.edu.queue;

import javafx.scene.shape.Circle;

import java.util.Scanner;

public class CircleArrayQueuedemo {
    public static void main(String[] args) {

        CircleArrayQueue caq = new CircleArrayQueue(3);//说明设置3，其队列的有效数据最大是2
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
                    caq.showQueue();continue;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入数字");
                    int value = sc.nextInt();
                    caq.addQueue(value);continue;

                case 'g':
                    try {
                        int queue = caq.getQueue();
                        System.out.println(queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                case 'h':
                    try {
                        int i = caq.headQueue();
                        System.out.println(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                default:
                    break;

            }
        }
        System.out.println("exit");

    }

    static class CircleArrayQueue {
        private int maxsize;//表示数组的最大容量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;//该数据用于存放数据，模拟队列

        //创建队列的构造器
        public CircleArrayQueue(int arrmaxSize) {
            maxsize = arrmaxSize;
            arr = new int[maxsize];
            front = 0;//指向队列头部，指向队列的第一个元素，默认可以不写
            rear = 0;//指向队列尾，指向队列最后一个元素的后一个位置，空出一个空间作为约定，默认可以不写
        }

        //判断队列是否满
        public boolean isFull() {
            return (rear + 1) % maxsize == front;
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
            //直接将数据加入
            arr[rear] = n;
            //将rear后移，这里必须考虑取模
            rear = (rear + 1) % maxsize;
        }

        //获取队列数据，出队列
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能获取数据");
            }
            //这里需要分析出front是指向队列的第一个元素
            int temp = arr[front];//先把front对应的值包留到一个临时变量
            front = (front + 1) % maxsize;//将front后移，取模
            return temp;//将临时变量返回

        }

        //显示队列的所有数据
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列为空！");
                return;
            }
            //从front开始遍历，遍历出有多少真实数据
            for (int i = front; i <front+ realDate(); i++) {
                System.out.printf("%d\t", arr[i % maxsize]);
            }

        }

        //显示队列的头数据
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空!");
            }
            return arr[front];
        }

        //求出当前队列的有效数据
        public int realDate() {
            return (rear + maxsize - front) % maxsize;
        }
    }
}
