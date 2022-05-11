package com.fannnnn.leetcode.DFS;

import java.beans.Visibility;
import java.nio.MappedByteBuffer;
import java.text.DateFormatSymbols;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 9:22
 * \*  Description:
 * \
 */

public class 省份数量 {

    /**
     * 题意是让我们找到所有相连的城市，每一个相连的部分就称作一个省份。因此我们从第一个城市开始遍历，找到与第一个城市相连且最近的城市，将城市该标为已来过，然后从该城市开始寻找与该城市相连的城市
     * 只要是经过的城市，就标记为已来过
     *
     * */

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0;i<n;++i){
            if(!visited[i]){
                dfs(isConnected,visited,n,i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int n,int i) {
        for(int j = 0;j<n;++j){
            if(isConnected[i][j]==1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected,visited,n,j);
            }
        }
    }

}
