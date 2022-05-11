package com.fannnnn.review.question136;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/23
 * \*  Time: 9:07
 * \*  Description:
 * \
 */

public class Solution {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1;i<nums.length;++i){
            res^=nums[i];
        }
        return res;
    }
}
