package com.offer.arrayorpoint;

/**
 * @Author: Lisy
 * @Date: 2022/08/25/9:37
 * @Description: 数组中出现超过一半的数字
 */
public class MajorityElement {

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] array = new int[]{1, 2, 3, 3, 4,4,4,4,4, 4,4, 4, 5, 2};
        int i = new MajorityElement().majorityElement(array);
        System.out.println("i = " + i);
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int votes = 0, target = 0;
        for (int num : nums) {
            if (votes == 0) {
                target = num;
            }
            votes += (target == num ? 1 : -1);
        }

        int count = 0;
        for (int num : nums) {
            if (target == num) {
                count++;
            }
        }

        return (count > nums.length >> 1 )? target : 0;
    }
}
