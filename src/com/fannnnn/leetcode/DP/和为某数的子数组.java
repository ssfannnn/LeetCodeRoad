package com.fannnnn.leetcode.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 16:15
 * \*  Description:
 * \
 */

public class 和为某数的子数组 {

    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for(int i = 0;i<nums.length;++i){
            int sum = 0;
            for(int j = 0;j<=i;++j){
                sum+=nums[j];
                if(sum==k) cnt++;
            }

        }
        return cnt;
    }

    public int subarraySum2(int[] nums, int k) {
        int cnt = 0,pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i<nums.length;++i){
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                cnt++;
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return cnt;
    }
}
