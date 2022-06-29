package com.fannnnn.reviewAgain.question704;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/20
 * \*  Time: 9:41
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 左右闭区间
     * */
    public int search1(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] > target) right = mid-1;
            else if(nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * 左闭右开区间
     * */

    public int search(int[] nums, int target) {
        int left = 0,right = nums.length;
        while (left<right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] > target) right = mid;
            else if(nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
