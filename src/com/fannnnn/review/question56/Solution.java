package com.fannnnn.review.question56;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 16:31
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 大致思路是 先将intercals按第一个元素进行排序 由小到大排序，通过比较第i个数组的最后一个元素和第i+1个数组的最后一个元素来决定是否要合并
     * 需要注意的是，由于这里需要我们返回一个数组，但是由于在合并的过程中，原数组的某些位置可能为空，因此我们需要另外一个集合来维护已经合并完的数组
     * 1.首先将数组的第一个元素放入queue中
     * 2.从数组的第二个元素开始遍历，将当前元素与queue的最后一个元素进行比较，若是需要合并，那么比较两个数组的第二个位置上的数，将queue尾部元素
     * 的第二个值更新为两数中的较大值，若不需要合并，直接将当前元素添加到queue的尾部
     *
     * */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(intervals[0]);
        int n = intervals.length;
        for(int i = 1;i<n;++i){
            int[] last = queue.getLast();
            if(intervals[i][0]<last[1]){
                int temp = Math.max(intervals[i][1],last[1]);
                int[] newElement = {last[0],temp};
                queue.removeLast();
                queue.addLast(newElement);
            }else {
                queue.add(intervals[i]);
            }
        }
        int[][] res = new int[queue.size()][2];
        int index = 0;
        while (!queue.isEmpty()){
            res[index++] = queue.poll();
        }
        return res;
    }

}
