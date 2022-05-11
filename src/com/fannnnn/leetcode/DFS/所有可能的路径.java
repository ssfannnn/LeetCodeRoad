package com.fannnnn.leetcode.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/4
 * \*  Time: 8:44
 * \*  Description:
 * \
 */

public class 所有可能的路径 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<Integer>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        deque.offerLast(0);
        dfs(graph,0);
        return res;
    }

    private void dfs(int[][] graph, int i) {
        if(i == graph.length-1){
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int gra : graph[i]) {
            deque.offerLast(gra);
            dfs(graph,gra);
            deque.removeLast();
        }
    }


}
