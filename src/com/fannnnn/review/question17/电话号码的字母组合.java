package com.fannnnn.review.question17;

import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/20
 * \*  Time: 8:21
 * \*  Description:
 * \
 */

public class 电话号码的字母组合 {


    public static List<String> letterCombinations(String digits) {
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
        StringBuffer buffer = new StringBuffer();
        dfs(digits,phoneMap,0,res,n,buffer);
        return res;

    }

    private static void dfs(String digits, Map<Character, String> phoneMap, int index, List<String> res,int n,StringBuffer buffer) {
        if(index==n){  //index表示当前到了第几个键 只要遍历到最后一个键的元素 将其添加进res并reutrn
            res.add(buffer.toString());
            return;
        }
        char ch = digits.charAt(index);
        String str = phoneMap.get(ch);
        for (char c : str.toCharArray()) {
            //当前遍历的键的元素加进来
            buffer.append(c);
            //进行下一层递归 找下一个键的元素
            dfs(digits,phoneMap,index+1,res,n,buffer);
            //回溯
            buffer.deleteCharAt(buffer.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
