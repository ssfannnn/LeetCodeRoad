package com.fannnnn.review.question79;

public class Solution {

    public boolean exist(char[][] board, String word) {
        int n = board.length,m = board[0].length;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){  //根据题意我们需要遍历board中的每一条路径，因此每一个起点都要寻找一次
                boolean res = dfs(board,word,i,j,0);
                if(res==true) return res;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j,int index) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length
                || board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1) return true;  //如果当前已经遍历到了word的最后一个元素 那么说明该条路径就是word 直接return true
        board[i][j] = '\0';
        boolean res = dfs(board,word,i+1,j,index+1) || dfs(board,word,i,j+1,index+1)
                || dfs(board,word,i-1,j,index+1) || dfs(board,word,i,j-1,index+1);
        board[i][j] = word.charAt(index); //回溯
        return res;
    }

}
