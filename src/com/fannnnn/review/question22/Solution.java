package com.fannnnn.review.question22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n==0) return list;
        dfs(list,n,n,new StringBuffer());
        return list;
    }
    private void dfs(List<String> list, int left, int right, StringBuffer buffer) {
        if(left==0 && right==0) {
            list.add(buffer.toString());
            return ;
        }
        //如果左括号此时多余右括号 说明这种情况已经不符合要求 直接return回上一层递归
        if(left > right) return;
        if(left > 0){
           dfs(list,left-1,right,buffer.append('('));
           buffer.deleteCharAt(buffer.length()-1);
        }
        if(right > 0){
            dfs(list,left,right-1,buffer.append(')'));
            buffer.deleteCharAt(buffer.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        for (String string : strings) {
            System.out.print(string+" ");
        }
    }

}
