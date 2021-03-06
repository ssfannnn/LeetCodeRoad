package com.fannnnn.leetcode.Exciting;

import sun.util.resources.cldr.ga.TimeZoneNames_ga;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/9
 * \*  Time: 9:37
 * \*  Description:
 * \
 */

public class 搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0;i<n;++i){
            if(nums[i] == target) return i;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return -1;
        if(n==1) return nums[0] == target ? 0 : -1;
        int l = 0,r = n-1;
        while (l <= r){
            int mid = l + ((r-l)>>1);
            if(nums[mid] == target) return mid;
            if(nums[0]<=nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    r = mid-1;
                }else {
                    l = mid + 1;
                }
            }else {
                if(target > nums[mid] && target<=nums[n-1]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
