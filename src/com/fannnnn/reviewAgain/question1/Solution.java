package com.fannnnn.reviewAgain.question1;

import javax.lang.model.type.IntersectionType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/23
 * \*  Time: 8:29
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 暴力
     * */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;++i){
            int num = nums[i];
            for(int j = i+1;j<nums.length;++j){
                if(nums[j] == target-num){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 哈希表
     * */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;++i){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }



}
