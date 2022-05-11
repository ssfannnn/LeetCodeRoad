package com.fannnnn.review.question39;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 15:55
 * \*  Description:
 * \
 */

public class Solution {

    /***
     *
     * 解这道题的关键在于递归的时候必须要带上candidates的下标，这是为了保证之后的遍历永远不会再从第0个元素开始，防止出现重复答案
     * */

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        if(n==0 || candidates==null || target==0) return res;
        List<Integer> list = new ArrayList<>();
        res = new ArrayList<>();
        dfs(candidates,target,list,0);//index参数是防止重复元素的关键参数
        return res;
    }

    private void dfs(int[] candidates, int target,List<Integer> list,int index) {
        if(target==0) {
            res.add(new ArrayList<>(list));
            return ;
        }
        if(target<0) return ;
        for(int i = index;i<candidates.length;++i){
            list.add(candidates[i]);
            target-=candidates[i];
            dfs(candidates,target,list,i);
            target+=candidates[i];
            list.remove(list.size()-1);
        }
    }
}
