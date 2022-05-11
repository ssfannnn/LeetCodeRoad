package com.fannnnn.leetcode.DFS;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 16:02
 * \*  Description:
 * \
 */

public class 岛屿数量 {

    int n,m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int res = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j>=m || grid[i][j]!='1') return;
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
