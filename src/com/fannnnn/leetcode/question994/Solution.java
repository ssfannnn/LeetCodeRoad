package com.fannnnn.leetcode.question994;

import com.sun.javafx.stage.PopupWindowPeerListener;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/29
 * \*  Time: 10:28
 * \*  Description:
 * \
 */

public class Solution {


    /**
     *广搜
     */

    public int orangesRotting(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == 2) queue.add(new int[]{i,j});
                else if(grid[i][j] == 1) cnt++;
            }
        }
        int res = 0;
        while (cnt > 0 && !queue.isEmpty()){
            res++;
            int size = queue.size();
            for(int k = 0;k<size;++k){
                int[] poll = queue.poll();
                int row = poll[0],col = poll[1];
                if(row-1>=0 && grid[row-1][col]==1){
                    grid[row-1][col] = 2;
                    cnt--;
                    queue.add(new int[]{row-1,col});
                }
                if(row+1<n && grid[row+1][col]==1){
                    grid[row+1][col] = 2;
                    cnt--;
                    queue.add(new int[]{row+1,col});
                }
                if(col-1>=0 && grid[row][col-1]==1){
                    grid[row][col-1] = 2;
                    cnt--;
                    queue.add(new int[]{row,col-1});
                }
                if(col+1 < m && grid[row][col+1]==1){
                    grid[row][col+1] = 2;
                    cnt--;
                    queue.add(new int[]{row,col+1});
                }
            }
        }
        if(cnt > 0) return -1;
        return res;
    }


    /**
     * 四个方向进行代码优化
     * */
    public int orangesRotting2(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int cnt = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == 2) queue.add(new int[]{i,j});
                else if(grid[i][j] == 1) cnt++;
            }
        }

        int res = 0;
        while (cnt > 0 && !queue.isEmpty()){
            res++;
            int size = queue.size();
            for(int k = 0;k<size;++k){
                int[] poll = queue.poll();
                for(int i = 0;i<4;++i){
                    int row = poll[0] + dir[i][0];
                    int col = poll[1] + dir[i][1];
                    if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1) {
                        grid[row][col] = 2;
                        cnt--;
                        queue.add(new int[]{row,col});
                    }
                }
            }
        }
        if(cnt > 0) return -1;
        else return res;
    }
}
