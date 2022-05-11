package com.fannnnn.leetcode.DP;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;
import sun.nio.cs.ext.MacArabic;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/15
 * \*  Time: 20:00
 * \*  Description:
 * \
 */

public class 最大正方形 {

/*    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        if(matrix==null || matrix[0].length==0 || matrix.length==0) return maxSquare;
        int row = matrix.length,col = matrix[0].length;
        for(int i = 0;i<row;++i){
            for(int j = 0;j<col;++j){
                if(matrix[i][j] == '1'){
                    maxSquare = Math.max(maxSquare,1);
                    //当前可能的最大正方形的边长
                    int currentMaxSide = Math.min(row-i,col-j);
                    for(int k = 1;k<currentMaxSide;++k){
                        boolean flag = true;
                        if(matrix[i+k][j+k]=='0') break;
                        for(int m = 0;m<k;++m){
                            if(matrix[i+k][j+m]=='0' || matrix[i+m][j+k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            maxSquare = Math.max(maxSquare,k+1);
                        }else {
                            break;
                        }
                    }
                }

            }
        }
        return maxSquare*maxSquare;
    }*/

    /**
     * 暴力解
     * **/

//    public int maximalSquare(char[][] matrix) {
//        int maxSquare = 0;
//        if(matrix==null || matrix.length==0 || matrix[0].length==0) return maxSquare;
//        int row = matrix.length,col = matrix[0].length;
//        for(int i = 0;i<row;++i){
//            for(int j = 0;j<col;++j){
//                if(matrix[i][j] == '1'){
//                    maxSquare = Math.max(maxSquare,1);
//                    int currentSide = Math.min(row-i,col-j);
//                    for(int k = 1;k<currentSide;++k){
//                        boolean flag = true;
//                        if(matrix[i+k][j+k]=='0') break;
//                        for(int m = 0;m<k;++m){
//                            if(matrix[i+k][j+m]=='0' || matrix[i+m][j+k]=='0') {
//                                flag = false;
//                                break;
//                            }
//                        }
//                        if(flag){
//                            maxSquare = Math.max(maxSquare,k+1);
//                        }else {
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return maxSquare*maxSquare;
//    }



    /**
     * 动态规划
     *
     * dp[i][j]表示以(i,j)为右下角的正方形的边长
     * 需要注意，在第一行的元素和第一列的元素，当它们作为正方形的右下角时，边长只能为1，即dp[i][j] = 1
     * 对于普遍位置，即需要由（i,j)的左边，上边，以及左上角的元素来决定，取三者中的最小值+1，即为dp[i][j]的值
     * 因此 状态转移方程为:dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1
     * */
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int n = matrix.length,m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(matrix[i][j] == '1'){
                   if(i==0 || j==0) {
                       dp[i][j] = 1;
                   }else {
                       dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                   }
                }
                max = max > dp[i][j] ? max : dp[i][j];
            }
        }
        return max*max;
    }
}
