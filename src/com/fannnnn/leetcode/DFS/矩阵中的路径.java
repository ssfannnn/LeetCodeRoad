package com.fannnnn.leetcode.DFS;

import java.lang.management.BufferPoolMXBean;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 8:40
 * \*  Description:
 * \
 */

public class 矩阵中的路径 {

    public boolean exist(char[][] board, String word) {
        for(int i = 0;i < board.length;++i){
            for(int j = 0 ; j < board[0].length; ++j){
                //找到每一条路径，从（i,j)出发找到每一条路径
                if(dfs(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        //如果出现下面的情况 说明该条路不符合题目 因此直接return false;
        if(i < 0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(index)) return false;
        //如果此时已经遍历到了最后一个元素 直接return true;
        if(index==word.length()-1) return true;
        //将当前遍历到的位置填为空
        board[i][j] = '\0';

        //往四周深搜
        boolean res = dfs(board,word,i+1,j,index+1) ||dfs(board,word,i-1,j,index+1) ||dfs(board,word,i,j+1,index+1) ||dfs(board,word,i,j-1,index+1);
        //回溯
        board[i][j] = word.charAt(index);
        return res;
    }
}
