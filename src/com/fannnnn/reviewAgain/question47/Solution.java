package com.fannnnn.reviewAgain.question47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/27
 * \*  Time: 11:53
 * \*  Description:
 * \
 */

public class Solution {


    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,list,visited);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, boolean[] visited) {
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0;i<nums.length;++i){
           if(visited[i] || (i>0 && nums[i] == nums[i-1] && !visited[i-1])) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums,list,visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
