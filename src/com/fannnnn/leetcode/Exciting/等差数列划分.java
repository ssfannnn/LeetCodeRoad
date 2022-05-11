package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 8:50
 * \*  Description:
 * \
 */

public class 等差数列划分 {

    public int numberOfArithmeticSlices(int[] nums) {
        int num = 0,ans = 0;
        for(int i = 2;i<nums.length;++i){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                num++;
                ans+=num;
            }else {
                num = 0;
            }
        }
        return ans;
    }
}
