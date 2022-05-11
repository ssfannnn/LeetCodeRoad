package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/9
 * \*  Time: 10:04
 * \*  Description:
 * \
 */

public class 在排序数组中查找元素的第一个和最后一个位置 {


    /**
     * 使用二分查找
     * 由于要找到target在数组中的第一个位置和最后一个位置，而题目也要求我们要使用复杂度为o(nlogn)，明示我们要用二分
     * 与常规题目不同的是，一旦我们使用二分找到了target也无法直接进行返回，因为我们要找的是最右边和最右边的target
     * 1.因此在找最左侧的target时，以 [5,7,7,8,8，10]为例，第一次mid在2位置，此时left = mid +1 = 3,下一次循环  mid = 4,找到target，但没有结束 还需往左寻找，因此将mid = right，
     * 继续循环，知道找到left
     * 2.在找最右侧的target时，与最左侧有些许不同，在于mid的值， 计算mid是 需要 +1 即 mid = （left+right+1)/2,否则mid会一直与right重合，造成死循环
     * */

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return new int[]{-1,-1};
        int firstPosition  = findFirstPosition(nums,target);
        if(firstPosition == -1) return new int[]{-1,-1};
        int lastPosition = findLastPosition(nums,target);
        return new int[]{firstPosition,lastPosition};
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left+right+1) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid; //继续往右寻找
            }
        }
        return left;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] < target) {
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                right = mid; //继续往左寻找
            }
        }

        if(nums[left]!=target) return -1;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(10 >>> 1);
    }
}
