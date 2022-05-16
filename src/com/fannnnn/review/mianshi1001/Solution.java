package com.fannnnn.review.mianshi1001;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/16
 * \*  Time: 9:02
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 方法一：直接插入以后进行排序
     * */
    public void merge(int[] A, int m, int[] B, int n) {
        int index = A.length-m-1;
        while (index>=m && n>0){
            A[index--] = B[n--];
        }
        Arrays.sort(A);
    }

    /**
     * 双指针
     * */
}
