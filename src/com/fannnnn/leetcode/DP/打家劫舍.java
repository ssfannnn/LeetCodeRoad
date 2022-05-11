package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 8:13
 * \*  Description:
 * \
 */

public class 打家劫舍 {

    /**
     *  首先遇到这样的题 可以肯定一定会有重复计算， 因此考虑采用动态规范的解法
     *  ①理清思路 我们需要找到最后能偷到的最大金额，因此将此问题分解至若干小问题，小偷偷到第i户人家时能偷到的最大金额，以数组[1,2,4,6,5]为例
     *  当小偷偷到第三户人家时 此时nums[3] = 6，此时需要计算在第三户人家以及之前的人家所偷到的总金额，因为相邻之间不能一起偷，因此小偷如果偷了nums[3]，那么它必定不可能偷nums[2]
     *  因此需要求出在第一户人家和第二户人家偷到金额的较大值，加上nums[3]，便是在第三户人家偷到的金额
     *  因此状态转移方程为 dp[i] = Max(dp[i-2]+nums[i],dp[i-3]+nums[i]+dp[i-4]+nums[i]+....+dp[0]+nums[i]);
     * **/

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[1];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2;i < n;++i){
            int max = dp[i-2];
            for(int j = i-2;j>=0;--j){
                if(dp[j] + nums[i] > max) {
                    max = dp[j] + nums[i];
                }
                dp[i] = max;
            }
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
}
