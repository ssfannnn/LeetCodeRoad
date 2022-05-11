package com.fannnnn.leetcode.Exciting;

import java.security.cert.PolicyQualifierInfo;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/13
 * \*  Time: 13:39
 * \*  Description:
 * \
 */

public class 队列的最大值 {

}

class MaxQueue {

    int[] queue;
    int begin = 0,end = 0;
    public MaxQueue() {
        queue = new int[20000];
    }

    public int max_value() {
        if(begin == end) return -1;
        int max = Integer.MIN_VALUE;
        int index = begin;
        while (index<end){
            max = queue[index] > max ? queue[index] : max;
            index++;
        }
        return max;
    }

    public void push_back(int value) {
        queue[end++] = value;
    }

    public int pop_front() {
        if(begin == end) return -1;
        return queue[begin++];
    }
}
