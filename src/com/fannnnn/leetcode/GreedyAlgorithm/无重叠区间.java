package com.fannnnn.leetcode.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 10:18
 * \*  Description:
 * \
 */

public class 无重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1]-o2[1]);
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for(int i = 1;i<n;++i){
            if(intervals[i][0]>right){
                ans++;
                right = intervals[i][1];
            }
        }
        return n-ans;
    }
}
