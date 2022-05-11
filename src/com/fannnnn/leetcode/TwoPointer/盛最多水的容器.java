package com.fannnnn.leetcode.TwoPointer;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 8:01
 * \*  Description:
 * \
 */

public class 盛最多水的容器 {

    /**
     * 从题目来看，这道题显然是从两边往中间走的流程，因此采用双指针的方式
     * ①一开始定义头尾指针 分别指向数组的头和尾
     * ②开始计算面积  长 * 宽 = Min(height[i],height[j]) * (j-i)
     * ③一次计算完之后 开始考虑指针怎么走 。如果左指针指向的数组的值小于右指针指向的数组的值，那么说明上回计算的长用的是二者中的较小值height[i],因此此时我要将i++,希望能找到一条较大的长计算得到更大的面积
     * ④如此遍历 当i==j时 遍历结束
     * **/

    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0,j = n-1;
        int max = 0;
        while (i<j){
            int area = Math.min(height[i],height[j]) * (j-i);
            if(area > max) max = area;
            if(height[i] <= height[j]) i++;
            else j--;
        }
        return max;
    }
}
