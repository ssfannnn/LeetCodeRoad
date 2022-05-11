package com.fannnnn.review.question11;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/19
 * \*  Time: 15:19
 * \*  Description:
 * \
 */

public class 装水最多的容器 {


    /**
     * 双指针法
     * */
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int n = height.length;
        int i = 0,j = n-1;
        int square = 0;
        // i j分别指向数组两端
        while (i<=j){
            //容器的长为下标相减的结果 高位左右指针所指向位置的较小值
            square = (j-i) * Math.min(height[i],height[j]);
            max = Math.max(square,max);
            //哪边的高较小，那么就往中间去寻找更大的高，以求得更大的面积
            if(height[i] <= height[j]) ++i;
            else --j;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
