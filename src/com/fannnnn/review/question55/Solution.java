package com.fannnnn.review.question55;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 16:22
 * \*  Description:
 * \
 */

public class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0;i<n;++i){
            if(i<=max){
                max = Math.max(max,i+nums[i]);
                if(max >= n-1) return true;
            }
        }
        return false;
    }
}
