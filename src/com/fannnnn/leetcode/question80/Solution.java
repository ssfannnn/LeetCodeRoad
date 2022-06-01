package com.fannnnn.leetcode.question80;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/1
 * \*  Time: 11:35
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 双指针
     * */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;
        int slow = 2,fast = 2;
        while (fast<n){
            if(nums[fast]!=nums[slow-2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
