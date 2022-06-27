package com.fannnnn.reviewAgain.question35;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/29
 * \*  Time: 8:57
 * \*  Description:
 * \
 */

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int index = 0;
        for(int i = 0;i<n;++i){
            if(target<=nums[i]) return i;
        }
        return n;
    }


    public int searchInsert2(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] > target) right = mid - 1;
            if(nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return right + 1;
    }
}
