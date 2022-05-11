package com.fannnnn.review.question416;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/29
 * \*  Time: 8:36
 * \*  Description:
 * \
 */

public class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2) return false;  //若是数组中的元素小于2个 说明无法分 直接return fakse
        int sum = 0,max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum+=num;
            max = num > max ? num : max;
        }
        if(max > sum/2 ) return false; //最大数大于总和的一半 说明一定不能分成相同的两部分
        if(sum%2==1) return false;  //总和为奇数  也不能分成相同的两部分
        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0;i<n;++i){
            dp[i][0] = true;  //dp[i][j]代表前i个数中取若干个数 总和为j的状态，当j=0时，所有元素都不取，因此dp[i][0]=true
        }
        dp[0][nums[0]] = true; //由于只取第一个元素时 第一个元素为nums[0]，因此dp[0][nums[0]] = true
        for(int i = 1;i<n;++i){
            for(int j = 1;j<=target;++j){
                // 当j>=nums[i],nums[i]有取或不取两种选择，若是取，则由dp[i-1][j-nums[i]]转移而来
                //若是不取 则由dp[i-1][j]转移而来
                if(j>=nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else {  //当j<nums[i]，说明此时nums[i]太大，必定不取
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
