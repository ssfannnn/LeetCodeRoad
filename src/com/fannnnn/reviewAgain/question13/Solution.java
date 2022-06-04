package com.fannnnn.reviewAgain.question13;

import java.util.HashMap;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/4
 * \*  Time: 9:32
 * \*  Description:
 * \
 */

public class Solution {

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};

        int res = 0;
        for(int i = 0;i<s.length();++i){
            Integer value = map.get(s.charAt(i));
            if(i<s.length()-1 && value < map.get(s.charAt(i+1))){  //如果当前位置的字符对应的哈希表中的值小于下一个字符对应的值，则进行减法操作
                res -= value;
            }else { //否则 进行加法操作
                res += value;
            }
        }
        return res;
    }
}
