package com.fannnnn.review.question33;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 14:46
 * \*  Description:
 * \
 */

public class 搜索旋转排序数组 {


    /***
     * 二分法： 需要注意的是 数组并经过旋转的 因此我们可以将数组分为有序和无序两部分，选取中间点
     * 如果nums[mid] >= nums[0] 说明左半部分有序 如果nums[mid]<nums[0] 说明右半部分有序
     * 若左半部分有序，先比较target与左半部分边界，若在左界，right = mid -1 ，否则 left = mid+1
     * 右半部分同理
     * */

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return -1;
        if(n==1) return nums[0]==target?0:-1;
        int left = 0,right = n-1;
        while (left<=right){
            int mid = left + ((right-left)>>1);
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[0]){
                if(nums[mid]>=target && nums[0]<=target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(nums[mid]<=target && target <= nums[n-1]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
