package com.fannnnn.review.question189;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/15
 * \*  Time: 9:56
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 用一个新数组
     * */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0;i<n;++i){
            res[(i+k)%n] = nums[i];
        }
        System.arraycopy(res,0,nums,0,nums.length);
    }

    /**
     * 在原有数组上进行元素位置交换
     * */
    public void rotate2(int[] nums,int k){
        int n = nums.length;
        k%=n;//k的值有可能大于nums的长度 因此这里必须要进行取余操作
        reverseArr(nums,0,n-1);
        reverseArr(nums,0,k-1);
        reverseArr(nums,k,n-1);
    }

    private void reverseArr(int[] nums, int start, int end) {
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
