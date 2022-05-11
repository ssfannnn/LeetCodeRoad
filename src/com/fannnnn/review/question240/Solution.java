package com.fannnnn.review.question240;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/25
 * \*  Time: 10:25
 * \*  Description:
 * \
 */

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m = matrix[0].length;
        int i = 0,j = m-1;
        while ((i>=0 && i<n) && (j>=0 && j<m)){
            if (matrix[i][j] > target){
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
