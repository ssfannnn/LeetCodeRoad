package com.fannnnn.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/14
 * \*  Time: 14:38
 * \*  Description:
 * \
 */

public class 子集 {


    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums,int index) {
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        list.add(nums[index]);
        dfs(nums,index+1);
        list.remove(list.size()-1);
        dfs(nums,index+1);
        return ;
    }
}
