package com.fannnnn.leetcode.question1037;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/8
 * \*  Time: 10:58
 * \*  Description:
 * \
 */

public class Solution {
    /**
     * 判断两条直线的斜率是否相等
     * */
    public boolean isBoomerang(int[][] points) {
        int[] ax = {points[0][0]-points[1][0],points[0][1]-points[1][1]};
        int[] ay = {points[0][0]-points[2][0],points[0][1]-points[2][1]};
        return ax[0]*ay[1]!=ax[1]*ay[0];
    }
}
