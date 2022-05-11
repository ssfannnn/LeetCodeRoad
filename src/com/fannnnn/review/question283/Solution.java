package com.fannnnn.review.question283;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/25
 * \*  Time: 10:54
 * \*  Description:
 * \
 */

public class Solution {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0,j=0;
        while (j<n){
            if(nums[j]!=0){
                swap(nums,i,j);
                ++i;
            }
            ++j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
