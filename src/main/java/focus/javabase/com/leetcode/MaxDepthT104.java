package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

//    3
//   / \
//  9  20
//    /  \
//   15   7
public class MaxDepthT104 {


    // 递归
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}