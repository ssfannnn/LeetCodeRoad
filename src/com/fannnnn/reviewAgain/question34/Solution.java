package com.fannnnn.reviewAgain.question34;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/29
 * \*  Time: 9:18
 * \*  Description:
 * \
 */

public class Solution {

    public static int[] searchRange(int[] nums, int target) {
        int l = search(nums,target);  //找到第一个等于target的
        int r = search(nums,target+1); //找到第一个大于target的
        if(nums[l]!=target || l==nums.length) return new int[]{-1,-1};
        return new int[]{l,r-1};
    }

    private static int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left < right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] >= target) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 1;
        searchRange(nums,target);
    }
}
