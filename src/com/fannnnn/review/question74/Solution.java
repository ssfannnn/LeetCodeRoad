package com.fannnnn.review.question74;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/16
 * \*  Time: 9:09
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 由矩阵的特性可知
     * 矩阵由左往右的数字变大  由上至下的数字变大
     * 因此我们从右上角出发 ：
     *                      1.若当前数字大于target 往左走
     *                      2.若当前数字小于target 往下走
     *                      3.若当前数字等于target 直接return true
     *                      4.如果超出边界 说明无答案 return false
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m = matrix[0].length;
        int i = 0,j = m-1;
        while (i>=0 && i<n && j>=0 && j<m){
            if(matrix[i][j] >target){
                --j;
            }else if(matrix[i][j] < target){
                ++i;
            }else {
                return true;
            }
        }
        return false;
    }
}
