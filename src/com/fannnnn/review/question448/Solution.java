package com.fannnnn.review.question448;

import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/30
 * \*  Time: 8:42
 * \*  Description:
 * \
 */

public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;++i){
            int index = (nums[i]-1)%n;  //算出原本每个数组应该对应的下标
            nums[index] += n; //已经出现的数字 +n,最后必定是>=n
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i<n;++i) {
            if(nums[i]<=n){  //若数组中的某个元素<=n  说明他并没有进行+n操作，说明该位置的原本应该有的元素没有出现，此时该加入res
                res.add(i+1);
            }
        }
        return res;
    }
}
