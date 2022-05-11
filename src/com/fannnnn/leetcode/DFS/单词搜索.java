package com.fannnnn.leetcode.DFS;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/14
 * \*  Time: 15:01
 * \*  Description:
 * \
 */

public class 单词搜索 {


    public boolean exist(char[][] board, String word) {
        int n = board.length,m = board[0].length;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                    if(dfs(board,word,i,j,0)) return true;
                }
            }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j,int index) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board,word,i+1,j,index+1) || dfs(board,word,i-1,j,index+1)
                || dfs(board,word,i,j-1,index+1) || dfs(board,word,i,j+1,index+1);
        board[i][j] = word.charAt(index);
        return res;
    }
}
