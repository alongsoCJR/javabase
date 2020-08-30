package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

public class HasPathSumT112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum == 0) {
            return false;
        }
        return sum(root, sum);
    }

    public static boolean sum(TreeNode root, int sum) {
        if (root != null && root.left == null) {
            return sum(root.right, sum - root.val);
        }

        if (root != null && root.right == null) {
            return sum(root.left, sum - root.val);
        }

        if (root == null) {
            return sum == 0 ? true : false;
        }
        return sum(root.left, sum - root.val) || sum(root.right, sum - root.val);
    }


    // 参考
    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum1(root.left, sum - root.val) ||
                hasPathSum1(root.right, sum - root.val);
    }
}