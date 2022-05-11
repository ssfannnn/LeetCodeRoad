package com.fannnnn.leetcode.Exciting;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/16
 * \*  Time: 11:12
 * \*  Description:
 * \
 */

public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        int slow = 0,fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre1!=pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;

    }
}
