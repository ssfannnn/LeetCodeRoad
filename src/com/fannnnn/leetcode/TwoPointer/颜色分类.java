package com.fannnnn.leetcode.TwoPointer;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/14
 * \*  Time: 12:25
 * \*  Description:
 * \
 */

public class 颜色分类 {

    public void sortColors(int[] nums) {
        int p0 = 0,p1 = 0;
        int n = nums.length;
        for(int i= 0;i<n; ++i){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0 < p1){
                    int tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = nums[i];
                }
                ++p0;
                ++p1;
            }else if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            }
        }
    }
}
