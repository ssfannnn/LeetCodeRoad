package com.fannnnn.review.question27;

import com.sun.org.apache.xerces.internal.util.SAXLocatorWrapper;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/29
 * \*  Time: 9:17
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 两层循环
     *
     * */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        for(int i = 0;i<n;++i){
            if(nums[i] == val) {
                for(int j = i+1;j<n;++j){
                    nums[j-1] = nums[j];
                }
                i--;
                n--;
            }
        }
        return n;
    }


    /**
     * 双指针
     * */
    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        for(int fast = 0;fast < n;fast++){
            if(nums[fast]!=val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }



}
