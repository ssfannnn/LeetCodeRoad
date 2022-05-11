package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/16
 * \*  Time: 10:15
 * \*  Description:
 * \
 */

public class 除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n==0) return new int[0];
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1;i<n;++i){
            res[i] = res[i-1] * nums[i-1];
        }

        int temp = 1;
        for(int j = n-2;j>=0;--j){
            temp *= nums[j+1];
            res[j] = res[j] * temp;
        }
        return res;
    }
}
