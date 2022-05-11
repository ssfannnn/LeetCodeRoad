package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/16
 * \*  Time: 10:43
 * \*  Description:
 * \
 */

public class 移动零 {


    /**
     * 双指针法，左指针指向已经处理完的数据的最右侧，右指针指向未经处理的数据的最左侧
     * 1.当右指针指向的位置的元素==0时，右指针向右移动
     * 2.当右指针指向的位置的元素！=0时，交换左右指针指向的元素，左指针向右移动，右指针向右移动
     * */

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0,right = 0;
        while (right<n){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums, int k, int j) {
        int temp = nums[k];
        nums[k] = nums[j];
        nums[j] = temp;
    }
}
