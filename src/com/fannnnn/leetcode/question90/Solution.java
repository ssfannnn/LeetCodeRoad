package com.fannnnn.leetcode.question90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/30
 * \*  Time: 8:44
 * \*  Description:
 * \
 */

public class Solution {


    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,list,0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        for(int i = index;i<nums.length;++i){
            if(i!=index && nums[i] == nums[i-1]) continue;  //
            list.add(nums[i]);
            dfs(nums,list,i+1);;
            list.remove(list.size()-1);
        }
    }
}
