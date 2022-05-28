package com.fannnnn.leetcode.question153;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/28
 * \*  Time: 8:50
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 二分查找
     * */
    public static int findMin(int[] nums) {
        int low = 0,high = nums.length-1;
        int mid = 0;
        while (low < high){
            mid = low + ((high-low)>>1);
            if(nums[mid] < nums[high]){  //若mid位置的值小于最右侧的值 说明最小值在mid位置的左侧 此时忽略mid位置的右半部分
                high = mid;
            }else {  //否则 说明最小值在mid位置的右侧 此时忽略mid位置的左半部分
                low = mid + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        findMin(a);
    }
}
