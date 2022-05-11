package com.fannnnn.leetcode.DFS;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/9
 * \*  Time: 8:49
 * \*  Description:
 * \
 */

public class 下一个排列 {

    /**
     * 一看这道题原本以为可以深搜找到所有的序列 然后直接取就好，但题目有要求 因此只能寻找别的途径
     * 具体做法
     * 1.从数组末尾开始往前遍历，一旦找到nums[k]  < nums[k+1] ,记录下当前k的位置
     * 2.如果当前k是<0的,说明当前数组时按降序排序的，因此直接翻转即可
     * 3.如果当前k>=0,那么从数组末尾开始往前遍历，知道nums[k2] > nums[k]，交换两个元素的位置
     * 4.由于一开始就是从后往前遍历的，因此k之后的一段必定是降序排序，因此要寻找下一个排列，我们要对k以后的数字进行升序排序
     *
     * */

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k1 = n-2;
        while (k1 >= 0 && nums[k1]>=nums[k1+1]) --k1;  //若k1<0 说明数组已经是一个降序的数组，如果是这种情况 直接翻转整个数组
        if(k1>=0){
            int k2 = n-1;
            while (k2 >= 0 && nums[k2]<=nums[k1]) --k2;
            swap(nums,k1,k2);
        }
        reverse(nums,k1+1,n-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j){
            if(nums[i] > nums[j]) {
                swap(nums,i,j);
            }
            ++i;
            --j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
