package com.fannnnn.leetcode.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/9
 * \*  Time: 8:24
 * \*  Description:
 * \
 */

public class 电话号码的字母组合 {

    /**
     * 看到排列组合 第一时间想到用回溯去做
     * ①首先将手机上的数字以及对应的数字放入Hash表中
     * ②通过构建一颗树来实现,以“23”数字为例
     *                                                      2
     *                                           'a'       'b'         'c'
     *                                            3         3           3
*                                           'd' 'e' 'f'   'd' 'e' 'f'  'd' 'e' 'f'
     *                                     "ab“ ”ae" "af"  "bd" "be" bf" "cd" ”ce" "cf"          '
     * */

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int n = digits.length();
        if(n==0) return res;
        Map<Character, String> phoneMap = new HashMap<Character, String>(){{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
        dfs(res,phoneMap,digits,0,new StringBuffer());
        return res;
    }

    private void dfs(List<String> res, Map<Character, String> phoneMap, String digits, int index,StringBuffer buffer) {
        if(index == digits.length()){
            res.add(buffer.toString());
            return ;
        }else {
            char ch = digits.charAt(index);
            String str = phoneMap.get(ch);
            int length = str.length();
            for(int i = 0;i<length;++i){
                buffer.append(str.charAt(i));
                dfs(res,phoneMap,digits,index+1,buffer);
                buffer.deleteCharAt(buffer.length()-1);
            }
        }
    }
}
