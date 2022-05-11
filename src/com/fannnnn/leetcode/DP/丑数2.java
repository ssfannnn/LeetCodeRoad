package com.fannnnn.leetcode.DP;

import com.sun.deploy.panel.ITreeNode;

import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/18
 * \*  Time: 15:20
 * \*  Description:
 * \
 */

public class 丑数2 {

    /**
     * 1.设定一个堆和一个排序队列，堆中和队列中放入第一个值1
     * 2.每次取出堆中的头一个元素，计算*2 *3 *5,但有个问题是一定会出现重复值，我们又不希望重复值出现，因此使用一个set集合来存储这些数据
     * */
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        set.add(1L);
        int[] nums = {2,3,5};
        //在循环外定义，最后一次计算得出的值即为第n个丑数
        int ugly = 0;
        for(int i = 0;i<n;++i){
            long x = queue.poll();
            ugly = (int) x;
            for (int num : nums) {
                long cur = ugly*num;
                if(set.add(cur)){
                    queue.offer(cur);
                }
            }
        }
        return ugly;
    }


    /**
     * 动态规划
     *
     * dp[i] 表示第i个丑数
     * 1.给定三个指针，初始时都指向1
     * 2.dp[i] = Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5])
     * 3.如果当前dp[i] == p(x) * (x),那么此指针向右移动一位
     * */

    public int nthUglyNumber2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p3 = 1, p2 = 1, p5 = 1;
        for(int i = 2;i<=n;++i){
            int num1 = dp[p2]*2,num2=dp[p3]*3,num3=dp[p5]*5;
            dp[i] = Math.min(Math.min(num1,num2),num3);
            if(dp[i]==num1){
                p2++;
            }
            if(dp[i]==num2){
                p3++;
            }
            if(dp[i]==num3){
                p5++;
            }
        }
        return dp[n];
    }


}
