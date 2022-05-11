package com.fannnnn.review.question139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/23
 * \*  Time: 9:10
 * \*  Description:
 * \
 */

public class Solution {

    /*
    * dp[i]表示前i位组成的字符串是否在set当中
    *
    *
    * */

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1;i<s.length();++i){
            for(int j = 0;j<i;++j){
                //如果 s[0:j] 和 s[j:i]都存在于set当中，说明前i个字符符合题目要求，dp[i]=true以后可以不用继续往下遍历 直接break
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
