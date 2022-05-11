package com.fannnnn.leetcode.DFS;

import java.text.DateFormatSymbols;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 11:00
 * \*  Description:
 * \
 */

public class 飞地的数量 {

    int n,m;
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        for(int i = 0;i<n;++i){
            dfs(grid,i,0);
            dfs(grid,i,m-1);
        }
        for(int j = 0;j<m;++j){
            dfs(grid,0,j);
            dfs(grid,n-1,j);
        }

        int ans = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == 0){
            return ;
        }
        grid[i][j] = 0;
        int[] mx = {1,0,0,-1};
        int[] my = {0,1,-1,0};
        for(int k = 0;k<4;++k){
            dfs(grid,i+mx[k],j+my[k]);
        }
    }

}
