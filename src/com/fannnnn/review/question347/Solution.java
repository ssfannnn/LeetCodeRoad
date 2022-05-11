package com.fannnnn.review.question347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/27
 * \*  Time: 10:35
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 堆思路
     * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1); //将所有元素极其个数都存入哈希表中
        }
        //初始化堆 令其升序
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Map.Entry<Integer, Integer> curMap : map.entrySet()) {
            if(queue.size()<k){ //若是堆中元素<k 直接放入
                queue.add(curMap.getKey());
            }else if(curMap.getValue() > map.get(queue.peek())){
                //堆中元素大于等于k，则要判断堆中最小的那个元素与当前准备要放进来的元素的大小
                // 若是大于当前堆中的最小元素，堆中最小元素出堆，再将当前元素放入堆中
                queue.remove();
                queue.add(curMap.getKey());
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()){
            res[index++] = queue.poll();
        }
        return res;
    }
}
