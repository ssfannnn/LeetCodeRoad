package com.fannnnn.review.question209;

public class Solution {


    /**
     * 暴力
     * */
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = n;
        int num = 0;
        for (int i : nums) {
            num+=i;
        }
        if(num < target) return 0;
        for(int i = 0;i<n;++i){
            int sum = 0;
            int res = 0;
            for(int j = i;j<n;++j){
                if (sum<target){
                    sum+=nums[j];
                    res+=1;
                }else break;
            }
            if(sum>=target) min = Math.min(min,res);
            if(min==1) return min;
        }
        return min;
    }


    /**
     * 滑动窗口
     * */
    public int minSubArrayLen2(int target, int[] nums){
        int n = nums.length;
        if(n==0) return 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (end<n){
            sum+=nums[end];
            while (sum >= target){ //sum大于target的时候 start不断右移
                min = Math.min(min,end-start);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE? 0 :min;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, a));
    }
}
