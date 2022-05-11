package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/7
 * \*  Time: 19:53
 * \*  Description:
 * \
 */

public class 二维数组中的查找 {

    /**
     * 方法一：
     * 遍历matrix的每一行
     * 对其中的每一行进行二分查找
     * */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        int m = 0;
        for(int i = 0;i<n;++i){
            m = matrix[i].length;
            int left = 0,right = m-1;
            while (left<=right){
                int mid =left + ((right-left)>>1);
                if(matrix[i][mid] == target) return true;
                else if(matrix[i][mid] > target) right--;
                else left++;
            }
        }
        return false;
    }



    /**
     * 方法二： 我们观察矩阵，可以看到该矩阵 从左至右的值递增 从上至下递增
     * 因此可以从右上角出发
     * 若 当前值大于target 当前位置向左移
     * 若当前值小于target 向下移动当前位置
     * 若当前值等于target return true
     * */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length == 0) return false;
        int n = matrix.length,m = matrix[0].length;
        int row = 0,col = m-1;
        while (row < n && col >=0){
            int nums = matrix[row][col];
            if(nums == target) return true;
            else if(nums < target) row++;
            else col--;
        }
        return false;
    }
}
