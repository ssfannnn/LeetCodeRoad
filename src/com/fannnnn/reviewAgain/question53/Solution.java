package com.fannnnn.reviewAgain.question53;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/29
 * \*  Time: 9:08
 * \*  Description:
 * \
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int max = nums[0];
        int sum = 0;
        for(int i = 0;i<n;++i){
            if(sum < 0) sum = 0; //一定要放在循环的第一句 因为在上一次循环加法之后 如果此时sum<0 则令sum = 0，若是先加再判断 则会影响下一个元素
            sum+=nums[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
