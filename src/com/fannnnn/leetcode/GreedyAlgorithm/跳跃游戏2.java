package com.fannnnn.leetcode.GreedyAlgorithm;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 9:18
 * \*  Description:
 * \
 */

public class 跳跃游戏2 {

    /**
     * 贪心算法解决  从第一步开始 找到下一步能够跳到的最远位置 如 nums = [2,3,1,1,5] 那么从第一个位置能够达到  下标为1和2的位置，对比看来 显然是下标为2时能到达的距离更远，因此第一步跳到1位置
     * 以此类推
     * 维护当前能够到达的最远位置maxPosition ，初始为0。 从第一个元素开始遍历，第一个元素能达到1位置和2位置，因此将边界放在2位置，然后开始遍历1-2位置，max = max(1+nums[1],2+nums[2])
     * 一旦遇到边界，更新边界为 max,同时步数+1，因为每一个更新边界代表需要走出前一步所能到达的最大下表，
     *
     * */

    public int jump(int[] nums) {
        int n = nums.length;
        int maxPosition = 0;
        int res = 0;
        int end = 0;
        for(int i = 0;i<n-1;++i){
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if(i == end) {
                end = maxPosition;
                res++;
            }
        }
        return res;
    }
}
