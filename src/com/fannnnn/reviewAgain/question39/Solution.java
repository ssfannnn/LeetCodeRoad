package com.fannnnn.reviewAgain.question39;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/27
 * \*  Time: 11:36
 * \*  Description:
 * \
 */

public class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates==null) return res;
        List<Integer> list = new ArrayList<>();
        dfs(candidates,list,target,0);
        return res;
    }

    private void dfs(int[] candidates, List<Integer> list, int target,int index) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return ;
        }
        if(target < 0) return ;
        for(int i = index;i<candidates.length;++i){
            target-=candidates[i];
            list.add(candidates[i]);
            dfs(candidates,list,target,i);
            list.remove(list.size()-1);
            target+=candidates[i];
        }
    }
}
