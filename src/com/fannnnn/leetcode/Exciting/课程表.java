package com.fannnnn.leetcode.Exciting;

import java.time.Period;
import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/24
 * \*  Time: 16:34
 * \*  Description:
 * \
 */

public class 课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //将课号和对应的入度放入哈希表中
        Map<Integer,Integer> inDegree = new HashMap<>();
        //将所有结点的入度全都初始化为0
        for(int i = 0;i<numCourses;++i){
            inDegree.put(i,0);
        }
        //邻接表
        Map<Integer, List<Integer>> adj = new HashMap<>();

        //更新结点入度
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[1];
            int next = prerequisite[0];
            //入度个数+1
            inDegree.put(next,inDegree.get(next)+1);
            if(!adj.containsKey(cur)){
                adj.put(cur,new ArrayList<>());
            }
            //更新邻接表
            adj.get(cur).add(next);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : inDegree.keySet()) {
            if(inDegree.get(key)==0){
                queue.add(key);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(!adj.containsKey(cur)) continue;
            List<Integer> list = adj.get(cur);
            for (Integer k : list) {
                inDegree.put(k,inDegree.get(k)-1);
                //如果有结点的入度变为0，将其放入队列
                if(inDegree.get(k)==0){
                    queue.offer(k);
                }
            }
        }
        //当inDegree中所有的入度都为0时，说明这是个有向无环图
        for (Integer key : inDegree.keySet()) {
            if(inDegree.get(key)!=0){
                return false;
            }
        }
        return true;
    }
}
