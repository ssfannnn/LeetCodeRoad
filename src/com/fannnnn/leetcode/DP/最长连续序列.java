package com.fannnnn.leetcode.DP;


import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/15
 * \*  Time: 9:35
 * \*  Description:
 * \
 */

public class 最长连续序列 {

    /**
     * 这道题需要注意的是 两个相邻的元素，若他们是连续的，则当前最长序列+1，若他们是相等的，那么最长序列继承前一个元素的最长序列，若相减>1，则dp[i] = 1
     * 因此状态转移方程为
     *
     *              dp[i] = {
     *                          dp[i-1]+1; nums[i] - nums[i-1] = 1;
     *                          dp[i-1];   nums[i] == nums[i-1];
     *                          1; nums[i]-nums[i-1]>1
     *              }
     *
     * */

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[n];
        dp[0] = 1;
//        Arrays.fill(dp,1);
        int max = dp[0];
        for(int i = 1;i<n;++i){
            if(nums[i] - nums[i-1] == 1) {
                dp[i] = dp[i-1] + 1;
            }else if(nums[i] == nums[i-1]){
                dp[i] = dp[i-1];
            }else {
                dp[i] = 1;
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}
