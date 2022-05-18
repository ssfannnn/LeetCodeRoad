package com.fannnnn.review.question47;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,list,visited,0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, boolean[] visited,int index) {
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i<nums.length;++i){
            //nums[i]==nums[i-1] &&!visited[i-1]  如果后一个节点在前面已经出现过了 那么说明以该数开头的全排列已经存在 因此直接跳过
            if(visited[i] || (i>0 && nums[i]==nums[i-1] &&!visited[i-1])){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums,list,visited,index+1);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
