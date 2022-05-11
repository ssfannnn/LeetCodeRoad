package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 10:58
 * \*  Description:
 * \
 */

public class StickersToSpellWord {

    public static int minStickers(String rest,String[] arr){
        if(rest.equals("")) return 0;
        int next = 0;
        for (String s : arr) {
            //rest减去s当中包含的字符

            //找出当前的数量
            int cur = minStickers(rest,arr);
            //next记录当前的最小值
            next = Math.min(next,cur);
        }
        return next + 1;
    }
}
