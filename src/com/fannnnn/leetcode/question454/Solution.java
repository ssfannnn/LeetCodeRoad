package com.fannnnn.leetcode.question454;

import java.util.HashMap;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/4
 * \*  Time: 10:10
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 首先遍历nums1和nums2 用哈希表存储 nums1和nums2中相加的值
     * 再遍历nums3和nums4，得出相加的值 由于我们要寻找nums1+nums2+nums3+nums4的情况，因此只需要在最后找到所有 0-num3-nums4的值存在的情况并且累加即可
     *
     * */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int temp = i+j;
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }

        int res = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int temp = i+j;
                if(map.containsKey(0-temp)){
                    res += map.get(0-temp);
                }
            }
        }
        return res;
    }
}
