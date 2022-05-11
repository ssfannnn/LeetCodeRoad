package com.fannnnn.review.question152;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/24
 * \*  Time: 7:35
 * \*  Description:
 * \
 */

public class Solution {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int[] maxDp = new int[n+1];
        int[] minDp = new int[n+1];
        maxDp[0] = minDp[0] = nums[0];
        int res = nums[0];
        for(int i = 1;i<nums.length;++i){
            maxDp[i] = Math.max(nums[i],Math.max(minDp[i-1]*nums[i],maxDp[i-1]*nums[i]));
            minDp[i] = Math.min(nums[i],Math.min(maxDp[i-1]*nums[i],minDp[i-1]*nums[i]));
            res = Math.max(res,maxDp[i]);
        }
        return res;
    }
}
