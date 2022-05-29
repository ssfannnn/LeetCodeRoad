package com.fannnnn.reviewAgain.question35;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/29
 * \*  Time: 8:57
 * \*  Description:
 * \
 */

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int index = 0;
        for(int i = 0;i<n;++i){
            if(target<=nums[i]) return i;
        }
        return n;
    }
}
