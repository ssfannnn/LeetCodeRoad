package com.fannnnn.review.question38;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/12
 * \*  Time: 20:30
 * \*  Description:
 * \
 */

public class Solution {

    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2;i<=n;++i){
            StringBuffer buffer = new StringBuffer();
            int start = 0;
            int pos = 0;
            while (pos < str.length()){
                while (pos<str.length() &&str.charAt(pos)==str.charAt(start)){  //遍历str 直到遍历到与开始的点不同的数
                    pos++;
                }
                buffer.append(Integer.toString(pos-start)).append(str.charAt(start)); //拼接数字出现的次数以及出现的数字
                start = pos;
            }
            str = buffer.toString();
        }
        return str;
    }

}
