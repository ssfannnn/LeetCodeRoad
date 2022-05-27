package com.fannnnn.reviewAgain.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/27
 * \*  Time: 10:43
 * \*  Description:
 * \
 */

public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int k = 0;k<n-2;++k){
            if(nums[k] > 0) break;
            if(k>0 &&nums[k]==nums[k-1]) continue;
            int i = k+1,j = n-1;
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i<j && nums[i]==nums[++i]);
                }else if(sum < 0){
                    while (i<j && nums[i] == nums[++i]);
                }else {
                    while (i<j && nums[j]==nums[--j]);
                }
            }
        }
        return res;
    }


}
