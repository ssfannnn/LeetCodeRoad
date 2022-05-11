package com.fannnnn.review.question494;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/30
 * \*  Time: 9:21
 * \*  Description:
 * \
 */

public class Solution {

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        //如果target>sum 说明即便全部加起来 也不可能得到答案 因此直接return 0
        if(Math.abs(target)>sum) return 0;
        //为什么这里size = sum * 2 +1 ？ 因为实际上我们需要考虑的状态数组 是一个对称的数组，他一定是关于数组最中间的一列对称的。为什么？因为dp中的元素有正有负也有零
        int size = sum*2+1;
        int[][] dp = new int[n][size];

        if(nums[0]==0){ //当nums[0] = 0；
            dp[0][sum] = 2;  //正0和负0，
        }else { //当只取数组中的第一个元素 ，我们需要填充与数组的值对应下标的位置的值，其余位置不用动，默认为0
            dp[0][sum-nums[0]] = 1;
            dp[0][sum+nums[0]] = 1;
        }

        //对于数组中的数字 有加和不加两种状态，两种状态对应的方案和就是dp[i][j]的值
        for (int i = 1;i<n;++i){
            for(int j = 0;j<size;++j){
                int l = j-nums[i] >= 0 ? j-nums[i] : 0;
                int r = j+nums[i] < size ? j+nums[i] : 0;
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }
        return dp[n-1][sum+target];
    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(arr, target));
    }
}
