package com.fannnnn.leetcode.DFS;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 11:22
 * \*  Description:
 * \
 */

public class 统计封闭岛屿的数目 {



    public int closedIsland(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        for(int i = 0;i<n;++i){
            dfs(grid,i,0,n,m);
            dfs(grid,i,m-1,n,m);
        }
        for(int j = 0;j<m;++j){
            dfs(grid,0,j,n,m);
            dfs(grid,n-1,j,n,m);
        }

        int ans = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == 0){
                    dfs(grid,i,j,n,m);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i,int j, int n, int m) {
        if(i < 0 || i>=n || j<0 || j>=m || grid[i][j] == 1)  return;
        grid[i][j] = 1;
        int[] mx = {1,0,0,-1};
        int[] my = {0,1,-1,0};
        for(int k = 0;k<4;++k){
            dfs(grid,i+mx[k],j+my[k],n,m);
        }
    }
}
