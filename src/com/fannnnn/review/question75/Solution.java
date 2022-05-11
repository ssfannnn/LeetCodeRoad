package com.fannnnn.review.question75;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/22
 * \*  Time: 7:52
 * \*  Description:
 * \
 */

public class Solution {

    public void sortColors(int[] nums) {
        int p0 = 0,p1 = 0;
        int n = nums.length;
        for(int i = 0;i<n;++i){
            if(nums[i] == 0){
                swap(nums,p0,i);
                if(p0<p1){
                    swap(nums,p1,i);
                }
                ++p1;
                ++p0;
            }else if(nums[i]==1) {
                swap(nums,i,p1);
                ++p1;
            }
        }
    }

    private void swap(int[] nums, int i, int p0) {
        int temp = nums[i];
        nums[i] = nums[p0];
        nums[p0] = temp;
    }
}
