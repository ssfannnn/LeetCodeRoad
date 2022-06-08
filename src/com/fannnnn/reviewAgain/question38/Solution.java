package com.fannnnn.reviewAgain.question38;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/8
 * \*  Time: 9:41
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 遍历生成
     * */
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2;i<=n;++i){
            StringBuffer buffer = new StringBuffer();
            int pos = 0;  //记录某段连续区间内相同数字出现的次数
            int start = 0; //该数字开始的位置
            while (pos < str.length()){
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)){
                    pos++;
                }
                buffer.append(Integer.toString(pos-start)).append(str.charAt(start));
                start = pos;
            }
            str = buffer.toString();
        }
        return str;
    }
}
