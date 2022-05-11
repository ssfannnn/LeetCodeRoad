package com.fannnnn.leetcode.DFS;

import java.text.DateFormatSymbols;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 10:04
 * \*  Description:
 * \
 */

public class 机器人的运动范围 {


    int ans = 0;
    int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        dfs(m,n,k,0,0,map);
        return ans;
    }

    private void dfs(int m, int n, int k, int i, int j,int[][] map) {
        //sum(i,j)表示i和j的各位之和 一旦超过给定k，就直接返回上一层递归  这里记得要标记已经走过的格子 否则会造成栈溢出
        if(i<0 || i>=map.length || j<0 || j>=map[0].length || sum(i,j)>k ||map[i][j]!=0) return ;
        ans++;
        map[i][j] = 1;
        for(int index = 0;index<4;++index){
            dfs(m,n,k,i+move[index][0],j+move[index][1],map);
        }
    }

    private int sum(int x, int y) {
        int ret = 0;
        while (x!=0){
            ret+=x%10;
            x/=10;
        }
        while (y!=0){
            ret+=y%10;
            y/=10;
        }
        return ret;
    }


    public static void main(String[] args) {
        机器人的运动范围 robot = new 机器人的运动范围();
        System.out.println(robot.movingCount(2, 3, 1));
    }

}
