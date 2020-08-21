package com.interview;

import java.util.Arrays;
import java.util.Random;

/**
 * @Date 2020/5/24 17:46
 * @Author by hp
 * @Description TODO
 */
public class Test {

    /**
     * 数组实现队列
     */

    public void test1() {
        StackRealizeQueue stackQueue = new StackRealizeQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        System.out.println("前两个");
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }

    /**
     * 最小栈测试
     */

    public void test2() {
        MinStack stack = new MinStack();

        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }


    public void test3() {
        FindNearestNumberDemo f = new FindNearestNumberDemo();
        int[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            numbers = f.findNearestNumber(numbers);
            System.out.println(Arrays.toString(numbers));
        }
    }


    public void test4() {
        RemoveDigitsToLeast r = new RemoveDigitsToLeast();
        String str = "9000593212";
        int k = 3;
        System.out.println("原来数:= " + str + "删除" + k + "个:" + "新的：" + r.removeDigits(str, k));
    }


    public void 特爽t() {
        int[] array = new int[]{2, 3, 1, 5, 1, 7, 1, 8, 1, 9};
        Arrays.sort(array);
        System.out.println("Arrays.toString(array) = " + array[array.length / 2]);
    }


    public void BigMumSum() {
        BigNumberSumDemo b = new BigNumberSumDemo();
        System.out.println(b.bigNumberSum("426709752318", "95481253129"));
    }


    public void GetBestGold() {
        long l = System.currentTimeMillis();
        GetBestGoldDemo ga = new GetBestGoldDemo();
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 90000};
        System.out.println("最优收益：" + ga.getBestGoldV2(w, p, g));
        long l1 = System.currentTimeMillis();
        System.out.println("time" + (l1 - l));
    }


    public void findMissingNumber() {
        Random random=new Random();
        int[] array = new int[100];
        for (int i = 0; i <100; i++) {
            array[i] = random.nextInt(100)+1;
        }
        System.out.println(Arrays.toString(array));
//        FindMissingNumberDemo f = new FindMissingNumberDemo();
//        System.out.println("f = " + f.findMissingNumber(array));
    }
}
