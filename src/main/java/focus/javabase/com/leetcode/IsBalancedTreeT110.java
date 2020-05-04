package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsBalancedTreeT110 {

    // 递归，理解错误
    public static boolean isBalanced0(TreeNode root) {
        return (maxDepth(root) - minDepth(root)) <= 1;
    }

//    public static int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }


    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            return depth(root.left) + 1;
        }
        if (root.right != null) {
            return depth(root.right) + 1;
        }
        return 0;
    }


    private static List<Integer> depthCount(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {

            }


        }

        return list;
    }


    // 参考
    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}