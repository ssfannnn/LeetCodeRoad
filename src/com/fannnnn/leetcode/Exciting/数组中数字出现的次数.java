package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/13
 * \*  Time: 12:00
 * \*  Description:
 * \
 */

public class 数组中数字出现的次数 {

    /**
     * 异或运算，由题意可知，数组中除了两个数以外，其他数字都出现了偶数次，我们要找到两个出现奇数次的数字
     * 1.将数组遍历一遍，由于相同的两个数字异或的结果为0，设两个出现奇数次的数字为a和b，最后得到的结果一定是a^b
     * 2.得到a^b的结果后我们知道a！=b，因此a^b的结果中一定存在一位是1，我们假设第k位是1
     * 3.设eo = a^b。  再设一个eo2 = 0，再对数组进行一次遍历，对第k位是1的数进行按位与运算，最后得到的结果就是其中一个答案
     * 4.由于异或运算符合结合律和交换律，因此另一个但就位eo^eo2
      */

    public int[] singleNumbers(int[] nums) {
        int eo = 0;
        int n = nums.length;
        for(int i = 0;i<n;++i){
            eo^=nums[i];
        }
        int mask = 1;
        while ((eo&mask) == 0) {
            mask <<= 1;
        }

        int eo2 = 0;
        for(int i = 0;i<n;++i){
            if((nums[i]&mask)==0){
                eo2^=nums[i];
            }
        }
        return new int[]{eo2,eo2^eo};
    }
}
