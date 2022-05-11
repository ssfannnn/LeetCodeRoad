package com.fannnnn.leetcode.TwoPointer;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/7
 * \*  Time: 20:45
 * \*  Description:
 * \
 */

public class 两数之和输入有序数组 {

    /**
     * 数组求和 双指针法  由于数组是非递减的
     * 初始时左指针指向数组最左侧  右指针指向数组最右侧
     * 当两指针指向位置相加 即  number[i] + number[j] == targte时  将当前两个位置 + 1 后在放入答案
     * 若 number[i] + number[j] > targte  右指针向左移动一位
     * 若number[i] + number[j] < targte  左指针向右移动一位
     * */

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0,j = numbers.length-1;
        while (i<j){
            int sum = numbers[i] + numbers[j];
            if( sum == target){
                res[0] = i;
                res[1] = j;
                break;
            }
            else if(sum > target) j--;
            else i++;
        }
        return res;
    }
}
