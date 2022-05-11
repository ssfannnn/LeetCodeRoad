package com.fannnnn.leetcode.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 20:31
 * \*  Description:
 * \
 */

public class 三数之和 {


    /**
     * 三重循环可做 但是缺点也是显而易见的 ①复杂度过高 三层循环时间复杂度o(n^3)  ②跳出循环以后还需要对结果进行去重操作
     *
     *因此这里采用双指针法，由于题目需要三个数相加结果为0，因此我们可以对数组进行排序处理后再进行操作
     * ①对数组进行排序
     * ②头指针k从0出发，由于有三个指针，因此要在最末尾留出两个指针来，i指针在k指针的后一位，j指针永远从最后一位出发
     * ③因为 相加为0，因此若k指针指向的值若有正数，那么i和j也必定都是正数，因此这部分可以进行优化 一旦nums[k] > 0，直接跳出循环
     * ④本题的难度在于去重，因此只要遇到相邻两个位置的值相等 直接跳过
     * ⑤确定i，j，k的位置之后，计算他们的和
     * ⑥若和小于零，那么我们需要将i指针往右移动，以增加sum的值，直至i和j重合 需要注意的是，遇到相邻两个值相等时直接跳过
     * ⑦若和大于零，那么我们需要将j指针往左移动，以减少sum的值，直至i和j重合 与上面一样，遇到相等的直接跳过
     * ⑧若和等于零，将结果加入res中，并且移动左右指针来寻找k为当前值时的下一种可能的结果
     *
     * */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0;k<n-2;++k){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1,j = n-1;
            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0) {
                    while (i < j && nums[i]==nums[++i]);
                }else if(sum > 0){
                    while (i < j && nums[j]== nums[--j]);
                }else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }


}
