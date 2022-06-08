package com.fannnnn.reviewAgain.question36;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/8
 * \*  Time: 10:30
 * \*  Description:
 * \
 */

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];   //纵坐标从1开始
        boolean[][] lie = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        for(int i = 0;i<9;++i){
            for(int j = 0;j<9;++j) {
                int bucketNo = 3*(i/3) + (j/3); //算出（i,j）是在第几个格子
                if(board[i][j]!='.'){
                    int num = board[i][j] - '0';
                    if(row[i][num] || lie[j][num] || bucket[bucketNo][num]){
                        return false;
                    }
                    row[i][num] = true;
                    lie[j][num] = true;
                    bucket[bucketNo][num] = true;
                }
            }
        }
        return true;
    }
}
