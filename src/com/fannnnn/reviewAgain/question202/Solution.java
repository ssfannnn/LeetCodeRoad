package com.fannnnn.reviewAgain.question202;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/4
 * \*  Time: 9:48
 * \*  Description:
 * \
 */

public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n!=1 && !set.contains(n)){
            set.add(n);
            n = calHappy(n);
        }
        return n==1;
    }

    private int calHappy(int n) {
//        String str  = String.valueOf(n);
//        int res = 0;
//        for (char ch : str.toCharArray()) {
//            res += Math.pow(Integer.parseInt(String.valueOf(ch)),2);
//        }
//        return res;
        int res = 0;
        while (n > 0){
            int x = n%10;
            res += x*x;
            n/=10;
        }
        return res;
    }
}
