package com.fannnnn.leetcode.Exciting;

import java.util.LinkedList;
import java.util.Queue;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/25
 * \*  Time: 9:49
 * \*  Description:
 * \
 */

public class 滑动窗口的最大值 {

    /*
    * 双端队列实现
    * */

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0) return new int[0];
        int[] res = new int[n-k+1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int right = 0;right<n;++right){
            //当队列不为空 且 队尾的元素小于滑动窗口最右侧的值，那么将队首出队，这样便可以保证队头存在的值是某一个滑动窗口的最大值
            while (!list.isEmpty() && nums[list.getLast()]<=nums[right]){
                list.removeLast();
            }
            //将滑动窗口最右侧的值加入队尾
            list.addLast(right);
            //计算滑动窗口左侧
            int left = right-k+1;
            //如果队头元素的下标小于left，那么说明这时要向右移动 将队头移除
            if(list.peekFirst() < left){
                list.removeFirst();
            }

            //如果right+1>=k 说明滑动窗口形成 此时将队头元素放入res中
            if(right+1>=k){
                res[left] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}
