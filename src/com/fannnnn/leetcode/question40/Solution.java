package com.fannnnn.leetcode.question40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/27
 * \*  Time: 10:02
 * \*  Description:
 * \
 */

public class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates==null || target==0) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list,candidates,target,0);
        return res;
    }

    private void dfs(List<Integer> list, int[] candidates, int target,int index) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = index;i< candidates.length;++i){
            if(target<candidates[i]) break;
            if(i>index && candidates[i]==candidates[i-1]) continue;
            target-=candidates[i];
            list.add(candidates[i]);
            dfs(list,candidates,target,i+1);
            list.remove(list.size()-1);
            target+=candidates[i];
        }
    }
}
