package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

public class LowestCommonAncestorT235 {


    // 递归
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode ret = getLowestCommonAncestor(root, p, q);
        return ret;
    }

    private static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return getLowestCommonAncestor(root.left, p, q);
        } else {
            return getLowestCommonAncestor(root.right, p, q);
        }
    }

    // 递归参考
    public static TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor0(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor0(root.right, p, q);
        }
        return root;
    }


    // 迭代参考
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

}