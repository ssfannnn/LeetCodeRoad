package com.fannnnn.review.question238;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/25
 * \*  Time: 9:03
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 第一次遍历计算 res[i]代表第i个数左侧的乘积
     * 第二次遍历计算 temp代表右侧某几个数的乘积，再与第一次遍历计算得到的res[i]相乘，便可以得到最终的答案
     * */

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n==0) return new int[0];
        int[] res = new int[n];
        for(int i = 0;i<n;++i){
            res[i] = 1;
        }
        for(int i = 1;i<n;++i){
            res[i] = res[i-1] * nums[i-1];
        }
        int temp = 1;
        for(int j = n-2;j>=0;--j){
            temp = temp * nums[j+1];
            res[j] = res[j] * temp;
        }
        return res;
    }
}
