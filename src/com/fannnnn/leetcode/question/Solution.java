package com.fannnnn.leetcode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/5
 * \*  Time: 11:13
 * \*  Description:
 * \
 */

public class Solution {

    /**
     *相比三数之和 多镶嵌了一层循环 注意sum的值要用long类型去接收 否则会溢出
     * */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n;++i){
            if(i>0 && nums[i-1]==nums[i]) continue;
            for(int j = i+1;j<n;++j){
                if(j>i+1 && nums[j-1]==nums[j]) continue;
                int left = j+1,right = n-1;
                while (right > left){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    }else if(sum < target){
                        left++;
                    }else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[right] == nums[right-1]) right--;
                        while (left < right && nums[left] == nums[left+1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
