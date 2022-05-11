package com.fannnnn.leetcode.BitArithmetic;

import java.util.stream.IntStream;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/4
 * \*  Time: 8:03
 * \*  Description:
 * \
 */

public class SumOfN {

    public int sumNums(int n) {
        return IntStream.range(1,n+1).sum();
    }
}
