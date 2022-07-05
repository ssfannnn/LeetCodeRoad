package com.fannnnn.leetcode.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/5
 * \*  Time: 8:27
 * \*  Description:
 * \
 */

public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<n-2;++i){
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1,k = n-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j<k && nums[j]==nums[++j]);
                }
                else if(sum<0) while (j<k && nums[j] == nums[++j]);
                else while (j<k && nums[k]==nums[--k]);
            }
        }
        return res;
    }
}
