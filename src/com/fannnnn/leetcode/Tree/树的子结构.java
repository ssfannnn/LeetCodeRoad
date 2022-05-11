package com.fannnnn.leetcode.Tree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
\*  Created with IntelliJ IDEA.
\*  @author shensifan
\*  Date: 2022/4/19
\*  Time: 12:59
\*  Description:
\*/

public class 树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }
    private boolean recur(TreeNode A, TreeNode B) {
        if(B==null) return true;
        if(A==null || A.val!=B.val) return false;
        return recur(A.left,B.left) &&recur(A.right,B.right);
    }

    public static void main(String[] args) {
         
    }

}
