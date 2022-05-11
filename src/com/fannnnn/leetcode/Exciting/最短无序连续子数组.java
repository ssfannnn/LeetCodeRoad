package com.fannnnn.leetcode.Exciting;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 16:53
 * \*  Description:
 * \
 */

public class 最短无序连续子数组 {

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n-1];
        int begin = 0,end = -1;
        for(int i = 0;i<n;++i){
            if(nums[i] < max){
                end = i;
            }else {
                max = nums[i];
            }
            if(nums[n-i-1] > min){
                begin = n-i-1;
            }else {
                min = nums[n-i-1];
            }
        }
        return end - begin +1;

    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str += 100);
        int[] a = {2,6,4,8,10,9,15};
        findUnsortedSubarray(a);
    }
}
