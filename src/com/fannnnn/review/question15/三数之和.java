package com.fannnnn.review.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/19
 * \*  Time: 15:35
 * \*  Description:
 * \
 */

public class 三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        int n = nums.length;
        for(int k = 0;k<n-2;++k){
            //若nums[k]>0 说明三数之和不可能等于0
            if(nums[k] > 0) break;
            //相邻元素直接跳过
            if(k>0 && nums[k]==nums[k-1]) continue;
            int i = k+1,j = n-1;
            while (i<j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    //去重
                    while (i<j && nums[i] == nums[++i]);
                }else if(sum<0){
                    while (i<j && nums[i] == nums[++i]);
                }else {
                    while (i<j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
