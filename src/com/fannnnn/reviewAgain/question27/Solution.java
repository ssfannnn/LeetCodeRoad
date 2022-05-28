package com.fannnnn.reviewAgain.question27;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/28
 * \*  Time: 9:47
 * \*  Description:
 * \
 */

public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int right = 0;right<nums.length;++right){
            if(nums[right]!=val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
