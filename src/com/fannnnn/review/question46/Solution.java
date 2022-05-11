package com.fannnnn.review.question46;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 16:06
 * \*  Description:
 * \
 */

public class Solution {

    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums.length==0) return res;
        list = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(nums,vis,list);
        return res;
    }

    private void dfs(int[] nums, boolean[] vis, List<Integer> list) {
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0;i<nums.length;++i){
            if(!vis[i]){
                list.add(nums[i]);
                vis[i] = true;
                dfs(nums,vis,list);
                vis[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
