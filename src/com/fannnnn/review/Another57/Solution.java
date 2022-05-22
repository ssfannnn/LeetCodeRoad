package com.fannnnn.review.Another57;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/22
 * \*  Time: 10:00
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * left = newInterval[0]  right = newInterval[1]
     * 从intervals的第一个元素开始遍历
     * 如果interval[1]小于left 说明当前的interval位于newInterval的左侧 没有重叠部分 可以直接插入res中
     * 如果interval[0]大于right 说明当前interval位于newInterval的右侧 没有重叠部分 这时将{left,right}插入数组  并且进行标记 之后不再插入
     * 如果不是上面两种情况 说明有重叠部分 此时left = Math.min(interval[0],left)  right = Math.max(interval[1],right)
     * 如果在遍历完成时 newInterval还没有插入 则将其插入到res的最后一个位置
     * */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean isUse = false;
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if(interval[1] < left) {
                res.add(interval);
            }else if(interval[0] > right){
               if(!isUse){
                   res.add(new int[]{left,right});
                   isUse = true;
               }
               res.add(interval);
            }else {
                left = Math.min(interval[0],left);
                right = Math.max(interval[1],right);
            }
        }
        if(!isUse){
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[0][]);
    }
}
