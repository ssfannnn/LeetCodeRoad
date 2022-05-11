package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 10:47
 * \*  Description:
 * \
 */

public class 打家劫舍2 {

    /**
     * 由于所有人家围城一个圈 因此头尾两个是不能够同时选择的，因此我们将人家划分为 0 ~ n-2  1-n-1两组，求其中的最大值
     * 如 1 2 5 4 3 2 6
     *   令i从start+2开始， dp[i] = max(dp[i-1],dp[i-2]+nums[i])
     * */

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        return Math.max(calRob(nums,0,n-2),calRob(nums,1,n-1));
    }
    private int calRob(int[] nums, int start, int end) {
        int first = nums[start],second = Math.max(nums[start],nums[start+1]);
        for(int i = start+2;i <= end ; ++i){
            int temp = second;
            second = Math.max(second,first+nums[i]);
            first = temp;
        }
        return second;
    }

    private int calRob2(int[] nums, int start, int end) {
        int[] dp = new int[nums.length-1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        for(int i = start+2;i<=end;++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
