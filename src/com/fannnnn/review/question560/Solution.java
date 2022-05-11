package com.fannnnn.review.question560;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * begin从0开始到nums的最后一个元素，end从begin出发，从后往前遍历 进行累加 一旦和等于k cnt++
     * */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for(int begin = 0;begin<n;++begin){
            int sum = 0;
            for(int end = begin;end>=0;--end){
                sum+=nums[end];
                if(sum==k) res++;
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0,1);
        for(int i = 0;i<nums.length;++i){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                res+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }



    public static void main(String[] args) {

    }


}
