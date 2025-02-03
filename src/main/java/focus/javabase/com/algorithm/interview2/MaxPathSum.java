package focus.javabase.com.algorithm.interview2;

import focus.javabase.com.leetcode.base.TreeNode;

public class MaxPathSum {


    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = root.val + Integer.max(maxPathSum(root.left), maxPathSum(root.right));
        return result;
    }


}