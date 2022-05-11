package com.fannnnn.leetcode.Matrix;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 9:43
 * \*  Description:
 * \
 */

public class 螺旋矩阵 {

    public int[][] generateMatrix(int n) {
        int num = 1;
        int l = 0,r = n-1,t = 0,b = n-1;
        int[][] matirx = new int[n][n];
        while (num<=n*n){
            for(int i = l;i<=r;++i){
                matirx[t][i] = num++;
            }
            ++t;

            for(int j = t;j<=b;++j){
                matirx[j][r] = num++;
            }
            --r;

            for(int k = r;k>=l;--k){
                matirx[b][k] = num++;
            }
            --b;

            for(int x = b;x>=t;--x){
                matirx[x][l] = num++;
            }
            ++l;
        }
        return matirx;
    }
}
