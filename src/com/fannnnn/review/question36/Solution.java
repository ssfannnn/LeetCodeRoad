package com.fannnnn.review.question36;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/11
 * \*  Time: 16:57
 * \*  Description:
 * \
 */

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] lie = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        for(int i = 0;i<9;++i){
            for(int j = 0;j<9;++j){
                int bucketNo = 3*(i/3) + (j/3); //计算当前在哪个桶
                if(board[i][j]!='.'){
                    int num = board[i][j]-'0';
                    if(row[i][num] || lie[j][num] || bucket[bucketNo][num]){  //如果该数字所在的行、列以及桶中有一个已经有该数字了 那么直接return false
                        return false;
                    }
                    //否则该数字对应的行列和桶都为true 标记该数字已经存在
                    row[i][num] = true;
                    lie[j][num] = true;
                    bucket[bucketNo][num] = true;
                }
            }
        }
        return true;
    }
}
