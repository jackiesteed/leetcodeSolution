package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/19/15.
 */
public class MaxDepthTree {

    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

}
