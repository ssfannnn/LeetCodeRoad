package com.fannnnn.leetcode.question16;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/28
 * \*  Time: 9:06
 * \*  Description:
 * \
 */

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int k = 0;k<n;++k){
            int i = k+1,j = n-1;
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if(Math.abs(sum-target) < Math.abs(res-target)){
                    res = sum;
                }
                if(sum < target) {
                    ++i;
                }else if(sum > target){
                    --j;
                }else {
                    return res;
                }
            }
        }
        return res;
    }
}
