package focus.javabase.com.leetcode;


import focus.javabase.com.leetcode.base.TreeNode;

public class IsSameTreeT100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            // 前序遍历
            return (p.val == q.val) && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }
        if (p == null && q == null) {
            return true;

        }
        return false;
    }


    // 前序遍历
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        printTree(node.right);
        System.out.print(node.val + " ");
    }


}