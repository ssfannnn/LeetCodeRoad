package com.fannnnn.review.question34;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 15:21
 * \*  Description:
 * \
 */

public class 在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return new int[]{-1,-1};
        int firstPosition = findFirstPosition(nums,target);
        if(firstPosition==-1) return new int[]{-1,-1};
        int lastPosition = findLastPosition(nums,target);
        return new int[]{firstPosition,lastPosition};
    }

    private int findLastPosition(int[] nums, int target) {
        int n = nums.length;
        int left = 0,right = n-1;
        while (left<right){
            int mid =(left + right + 1) >>> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                left = mid;
            }
        }
        return left;
    }

    private int findFirstPosition(int[] nums, int target) {
        int n = nums.length;
        int left = 0,right = n-1;
        while (left<right){
            int mid =left + ((right-left)>>1);
            if (nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if(nums[left]!=target) return -1;
        return left;
    }
}
