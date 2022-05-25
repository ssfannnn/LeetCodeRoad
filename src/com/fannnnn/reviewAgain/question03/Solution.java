package com.fannnnn.reviewAgain.question03;

import java.util.HashMap;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/23
 * \*  Time: 9:16
 * \*  Description:
 * \
 */

public class Solution {



    /**
     * 滑动窗口
     * */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int i = 0;i<s.length();++i){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                l = Math.max(l,map.get(ch)+1);
            }
            map.put(ch,i);
            max = Math.max(i-l+1,max);
        }
        return max;
    }
}
