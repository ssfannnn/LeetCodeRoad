package com.fannnnn.leetcode.Tree;

import jdk.nashorn.internal.ir.BlockLexicalContext;

import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 10:37
 * \*  Description:
 * \
 */

public class 路径总和 {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null){
            return targetSum-root.val==0;
        }
        return  hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }



}
