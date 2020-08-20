package com.interview;

/**
 * @Date 2020/5/28 9:45
 * @Author by hp
 * @Description 删除k个元素的最小值
 * • 把原整数的所有数字从左到右进行比较，
 * • 如果发现某一位数字大于它右面的数字，那么在删除该数字后，必然会使该数位的值降低，
 * `  因为右面比它小的数字顶替了它的位置。
 */
public class RemoveDigitsToLeast {

    public String removeDigits(String nums, int k) {
        String newNums = nums;
        for (int i = 0; i < k; i++) {
            //是否找到要删除的数字
            boolean hascut = false;

            for (int j = 0; j < newNums.length() - 1; j++) {
                if (newNums.charAt(j) > newNums.charAt(j + 1)) {
                    //substring 左闭右开区间 删除j下标元素
                    newNums = newNums.substring(0, j) + newNums.substring(j + 1, newNums.length());
                    hascut = true;
                    break;
                }
            }
            //如果没有找到则删除最后一个数字
            if (!hascut) {
                newNums = newNums.substring(0, newNums.length() - 1);
            }
            //清除整数左侧的0
            newNums = removeZero(newNums);
        }
        return newNums;
    }

    /**
     * 删除左侧的零
     * @param newNums 有0的字符串
     * @return 没有零的字符串
     */
    private String removeZero(String newNums) {
        for (int i = 0; i <newNums.length()-1 ; i++) {
            if (newNums.charAt(0)!='0'){
                break;
            }
            newNums=newNums.substring(1,newNums.length());
        }
        return newNums;
    }
}
