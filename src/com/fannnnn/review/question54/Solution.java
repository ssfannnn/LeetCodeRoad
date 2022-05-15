package com.fannnnn.review.question54;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/15
 * \*  Time: 9:12
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 模拟
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length,m = matrix[0].length;
        if(n==0 || m==0 || matrix==null){
            return res;
        }
        int[][] mv = {{0,1},{1,0},{0,-1},{-1,0}}; //控制方向
        boolean[][] visited = new boolean[n][m]; //判断当前位置是否走过
        int row = 0,col = 0;
        int total = n * m;
        int index = 0;
        for(int i = 0;i<total;++i){
            res.add(matrix[row][col]);
            visited[row][col] = true;//标记位置
            int nextRow = row + mv[index][0],nextCol = col + mv[index][1]; //计算得到将要到达的下一个位置
            if(nextRow<0 || nextRow >=n || nextCol<0 || nextCol>=m || visited[nextRow][nextCol]){ //若下一个位置越界，改变方向
                index = (index+1)%4;
            }
            row+=mv[index][0];
            col+=mv[index][1];
        }
        return res;
    }

    /**
     * 按层遍历
     * */
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length,m = matrix[0].length;
        if(n==0 || m==0 || matrix==null){
            return res;
        }
        int left = 0,right = m-1,top = 0,bottom = n-1;
        while (left<=right && top<=bottom){
            for(int i = left;i<=right;++i){
                res.add(matrix[top][i]);
            }
            for(int j = top+1;j<=bottom;++j){
                res.add(matrix[j][right]);
            }
            if(left<right && top<bottom){  //如果只有一行的话则不需要再进行向下打印
                for(int k = right-1;k>left;--k){
                    res.add(matrix[bottom][k]);
                }
                for(int t = bottom;t>top;--t){
                    res.add(matrix[t][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

}
