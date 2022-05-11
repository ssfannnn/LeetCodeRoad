package com.fannnnn.leetcode.Exciting;

import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/16
 * \*  Time: 14:20
 * \*  Description:
 * \
 */

public class 高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {

        /**
         * 思路：将数组中的元素放到Hash表中，同一个key每出现一次，对应的value+1
         *      遍历整个哈希表 将key放入堆中，这里用到PriorityQueue，使用比较器让堆中的元素自动排序
         *
         *     1.如果当前堆中的元素个数小于k时，那么直接放入哈希表中的元素
         *     2.如果堆中元素=k，且下一个哈希表中的value>当堆中第一个元素的值，那么就将该元素换出
         *     3.将处理完的结果放入数组中返回
         * */

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Map.Entry<Integer, Integer> curMap : map.entrySet()) {
            if(queue.size()<k){
                queue.add(curMap.getKey());
            }else if(curMap.getValue() > map.get(queue.peek())){
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


    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        topKFrequent(arr,2);
    }
}
