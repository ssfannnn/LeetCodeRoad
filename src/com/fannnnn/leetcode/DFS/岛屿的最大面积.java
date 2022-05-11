package com.fannnnn.leetcode.DFS;

import java.text.DateFormatSymbols;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 13:08
 * \*  Description:
 * \
 */

public class 岛屿的最大面积 {

    int n,m;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == 1){
                    int count = dfs(grid,i,j);
                    ans = count > ans ? count : ans;
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >=n || j < 0 || j>=m || grid[i][j]==0) return 0;
        int ans = 1;
        grid[i][j] = 0;
        int[] mvx = {1,0,0,-1};
        int[] mvy = {0,1,-1,0};
        for(int x = 0;x < 4;++x){
            ans += dfs(grid,i+mvx[x],j+mvy[x]);
        }
        return ans;
    }
}
