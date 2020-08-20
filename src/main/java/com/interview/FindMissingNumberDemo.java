package com.interview;

/**
 * @Date 2020/6/2 19:46
 * @Author by hp
 * @Description 找到缺少的整数
 */
public class FindMissingNumberDemo {

    /**
     *先算出1+2+3+…+100的和，然
     * 后依次减去数组里的元素，最后得到的差值，就是那个缺失的整数。
     * @param nums 原数组
     * @return 缺少的整数
     * 时间复杂度 O(n)，
     * 空间复杂度 O(1)
     */
    public int findMissingNumber(int[] nums){
        int sum=0;
        for (int i = 1; i <=100 ; i++) {
            sum+=i;
        }

        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
