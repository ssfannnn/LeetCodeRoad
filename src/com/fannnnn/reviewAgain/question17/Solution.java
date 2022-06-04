package com.fannnnn.reviewAgain.question17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/4
 * \*  Time: 9:41
 * \*  Description:
 * \
 */

public class Solution {

    Map<Character,String> map = new HashMap<Character,String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits==null || "".equals(digits)) return res;
        StringBuffer buffer = new StringBuffer();
        dfs(digits,map,buffer,0);
        return res;

    }

    private void dfs(String digits, Map<Character, String> map, StringBuffer buffer, int i) {
        if(i==digits.length()){
            res.add(buffer.toString());
            return ;
        }
        String str = map.get(digits.charAt(i));
        for (char c : str.toCharArray()) {
            buffer.append(c);
            dfs(digits,map,buffer,i+1);
            buffer.deleteCharAt(buffer.length()-1);
        }
    }
}
