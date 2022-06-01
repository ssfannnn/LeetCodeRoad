package com.fannnnn.leetcode.question73;

import javax.swing.plaf.SliderUI;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/1
 * \*  Time: 8:53
 * \*  Description:
 * \
 */

public class Solution {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        boolean[] col = new boolean[n];
        boolean[] row = new boolean[n];
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[i] = true;
                }
            }
        }
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(a);
    }
}
