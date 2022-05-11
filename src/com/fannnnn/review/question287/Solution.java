package com.fannnnn.review.question287;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/27
 * \*  Time: 8:07
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 二分查找 [1,3,4,2,2]
     * 我们用一个数组cnt  cnt[i]代表小于等于i的元素的个数
     * 从中间mid开始  计算出mid后，遍历nums，一旦出现小于等于mid的数组 令cnt++
     * 最后 判断 cnt与mid之间的大小关系 如果cnt<=mid 说明重复值一定出现在右边 此时left = mid ,若cnt>mid 说明重复值出现在左边，此时right=mid-1
     * 需要注意的是 我们的mid指得是元素的下标
     * 这么看 将数组排序[1,2,2,3,4],第一次mid是2，即中间元素2的位置，
     * 遍历数组以后以后发现 <=2的元素有3  即cnt=3，而正常来讲，1-n之间的数，<=i的数应该有i个，而现在<=2的数有3个，说明1-3之间必定有
     * 重复数 ，如果往左边找；反之则往右边找
     *
     * */

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0,right = n-1;
        int ans = -1;
        while (left<right){  // left < right 是为了保证最后退出循环的时候left=right
            int mid = (left+right)>>1;
            int cnt = 0;
            for (int num : nums) {
                if(num<=mid){
                    cnt++;
                }
            }
            if(cnt<=mid){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }


    /**
     * 哈希表
     * */

    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 快慢指针
     * */
    public int findDuplicate3(int[] nums) {
        int slow = 0,fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow!=fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
