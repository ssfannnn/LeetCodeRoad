package com.fannnnn.leetcode.Exciting;

import javafx.scene.media.MediaErrorEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/14
 * \*  Time: 10:57
 * \*  Description:
 * \
 */

public class 合并区间 {

    /**
     * 首先对数组中的元素进行排序，比较第一个元素 这里使用lambda表达式可以做
     *1.将intervals的第一个元素先放入list集合中
     *2.从数组的第一个元素开始遍历，如果当前遍历到的数组的第一个元素小于等于list集合中最后一个数组的第二个元素，
     * 那么比较list集合中最后一个数组的第二个元素与当前遍历到的数组的第二个元素，取其中大的值，覆盖list集合的最后一个数组的第二个元素
     * 如果大于list集合中最后一个数组的第二个元素，那么直接将当前数组添加进list集合
     * */

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1;i < intervals.length;++i){
            int[] arr = list.get(list.size() - 1);
            if(arr[1] >= intervals[i][0]){
                list.get(list.size()-1)[1] = Math.max(arr[1],intervals[i][1]);
            }else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
