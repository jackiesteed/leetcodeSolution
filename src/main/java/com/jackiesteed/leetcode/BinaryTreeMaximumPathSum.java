package com.jackiesteed.leetcode;

/**
 * Created by fangxue on 15/11/29.
 */
public class BinaryTreeMaximumPathSum {



    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
    }


    public int maxPathSum(TreeNode root) {

        return innerCalc(root)[1];
    }

    public int[] innerCalc(TreeNode root){
        if(root == null){
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }
        if(root.left == null && root.right == null){
            return new int[]{root.val, root.val};
        }
        int[] res = new int[2];
        int[] leftRes = innerCalc(root.left);
        int[] rightRes = innerCalc(root.right);
        res[0] = root.val + Math.max(0, Math.max(leftRes[0], rightRes[0]));
        res[1] = Math.max(leftRes[1], rightRes[1]);
        int tmp = root.val;
        if(leftRes[0] > 0) tmp += leftRes[0];
        if(rightRes[0] > 0) tmp += rightRes[0];
        res[1] = Math.max(res[1], tmp);

        return res;
    }
}
