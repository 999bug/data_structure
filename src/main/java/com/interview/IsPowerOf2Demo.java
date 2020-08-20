package com.interview;

/**
 * @Date 2020/5/24 8:39
 * @Author by hp
 * @Description 判断一个数是否为2的整数次幂
 */
public class IsPowerOf2Demo {
    public boolean isPowerOf2(int num){
        return (num&num-1)==0;
    }
}
