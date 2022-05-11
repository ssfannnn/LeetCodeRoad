package com.fannnnn.leetcode.Exciting;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 17:59
 * \*  Description:
 * \
 */

public class 每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i = 0;i<n;++i){
            int temperature = temperatures[i];
            while (!st.isEmpty() && temperature > temperatures[st.peek()]){
                int pre = st.pop();
                res[pre] = i-pre;
            }
            st.push(i);
        }
        return res;
    }
}
