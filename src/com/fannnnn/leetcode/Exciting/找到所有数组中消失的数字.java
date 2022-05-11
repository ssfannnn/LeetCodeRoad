package com.fannnnn.leetcode.Exciting;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 14:02
 * \*  Description:
 * \
 */

public class 找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;++i){
            int x = (nums[i]-1)%n; //算出nums中每一个数字原本应该对应的下标
            nums[x] += n;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<n;++i){
            if(nums[i] <= n) res.add(i+1);
        }
        return res;
    }
}
