package com.fannnnn.reviewAgain.question283;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/5
 * \*  Time: 8:42
 * \*  Description:
 * \
 */

public class Solution {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int fast = 0,slow = 0;
        while (fast<n){
            if(nums[fast]!=0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
