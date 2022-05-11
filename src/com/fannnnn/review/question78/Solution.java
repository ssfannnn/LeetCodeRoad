package com.fannnnn.review.question78;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        //由于每个子集都要进来 所以每次进入递归的时候直接把当前的子集加入res中
        res.add(new ArrayList<>(list));
        if(index==nums.length) {
            return;
        }
        for(int i = index;i<nums.length;++i){
            list.add(nums[i]);
            dfs(nums,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        solution.subsets(arr);
    }
}
