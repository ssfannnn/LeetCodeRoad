package com.fannnnn.review.question26;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/1
 * \*  Time: 11:15
 * \*  Description:
 * \
 */

public class Solution {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int fast = 1,slow = 1;
        while (fast < n){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
