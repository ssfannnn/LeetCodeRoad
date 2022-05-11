package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/13
 * \*  Time: 14:11
 * \*  Description:
 * \
 */

public class 构建乘积数组 {

    /***
     * 由于不能用除法，因此我们采用对于a中某一个位置，它对应的res数组中的值，先进行对它前面数字的乘积操作，再进行后面数字的乘积操作
     *具体的：
     * res[i] = res[i-1] * a[i-1]; 代表第i的位置的值等与它之前位置所有值的乘积
     * {
     *     temp = temp * a[j+1]
     *     res[j] = res[j]*temp;
     * }  代表第j位置的值等于当前res[j]的值与它后面的值的乘积
     *
     */


    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n==0) return new int[0];
        int[] res = new int[n];
        int index = 0;
        res[0] = 1;
        for(int i = 1;i<n;++i){
            res[i] = res[i-1] * a[i-1];
        }
        int temp = 1;
        for(int j = n-2;j>=0;--j){
            temp = temp*a[j+1];
            res[j]*=temp;
        }
        return res;
    }
}
