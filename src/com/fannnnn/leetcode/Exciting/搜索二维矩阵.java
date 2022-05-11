package com.fannnnn.leetcode.Exciting;

import sun.nio.cs.ext.MacArabic;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/16
 * \*  Time: 10:25
 * \*  Description:
 * \
 */

public class 搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m = matrix[0].length;
        int i = 0,j = m-1;
        while (i>=0 && j>=0 && i<n && j<m){
            if(matrix[i][j] > target) --j;
            else if(matrix[i][j] < target) ++i;
            else return true;
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length,m = matrix[0].length;
        for(int i = 0;i<n;++i){
            int left = 0, right = m-1;
            while (left<=right){
                int mid = left + ((right-left)>>1);
                if(matrix[i][mid] < target) {
                    left = mid+1;
                }else if(matrix[i][mid] > target) {
                    right = mid-1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
