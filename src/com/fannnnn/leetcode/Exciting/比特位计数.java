package com.fannnnn.leetcode.Exciting;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/16
 * \*  Time: 13:05
 * \*  Description:
 * \
 */

public class 比特位计数 {

    /**
     * i为奇数时，二进制的1的个数为前一个偶数的个数+1
     * i为偶数时，二进制1的个数为 i%2的个数,相比i/2,左移了一位
     * */

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i = 1;i<=n;++i){
            if(i%2==1){
                res[i] = res[i-1] + 1;
            }else {
                res[i] = res[i/2];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = countBits(3);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
