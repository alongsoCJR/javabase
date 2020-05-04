package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

//    3
//   / \
//  9  20
//    /  \
//   15   7
public class MinDepthT111 {


    // 递归
    public static int minDepth(TreeNode root) {
        if (root != null && root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root != null && root.right == null) {
            return minDepth(root.left) + 1;
        }

        if (root == null) {
            return 0;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    private static int min(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}