package com.fannnnn.review.question200;

import java.text.DateFormatSymbols;
import java.util.concurrent.ForkJoinPool;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/24
 * \*  Time: 15:32
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 深度优先搜索 i=0,j=0开始遍历，一旦遇到‘1’，res+1,从这个位置开始进行深搜，遇到递归遇到的每一个1，都将其改为0，
     * 这样做是为了把与起点相连的1全部都拿掉，之后遍历时便不会再因为这些1混乱，最终有多少个起点 就说明有多少个岛屿
     * **/


    int n,m;
    public int numIslands(char[][] grid) {
        n  = grid.length;
        m = grid[0].length;
        if(n==0 || m==0) return 0;
        int res = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=n ||j<0 || j>=m || grid[i][j]=='0'){
            return ;
        }
        grid[i][j] = '0';
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }
}
