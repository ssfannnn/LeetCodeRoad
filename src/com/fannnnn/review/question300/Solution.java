package com.fannnnn.review.question300;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/27
 * \*  Time: 8:53
 * \*  Description:
 * \
 */

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        for(int i = 0;i<n;++i){
            dp[i] = 1;
            for(int j = 0;j<=i;++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}
