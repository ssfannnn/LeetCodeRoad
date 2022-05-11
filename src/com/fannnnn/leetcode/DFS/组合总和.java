package com.fannnnn.leetcode.DFS;

import javax.sound.sampled.LineUnavailableException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/7
 * \*  Time: 20:06
 * \*  Description:
 * \
 */

public class 组合总和 {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates,target,list,0);
        return res;
    }

    public void dfs(int[] candidates, int target, List<Integer> list,int index) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<candidates.length;++i){
            list.add(candidates[i]);
            dfs(candidates,target-candidates[i],list,i);
            list.remove(list.size()-1);
        }
    }


}
