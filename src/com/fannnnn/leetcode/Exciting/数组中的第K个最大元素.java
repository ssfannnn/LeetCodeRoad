package com.fannnnn.leetcode.Exciting;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/15
 * \*  Time: 18:55
 * \*  Description:
 * \
 */

public class 数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
