package focus.javabase.com.algorithm.interview2;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Jianrong.Chen
 * @Description 层次遍历
 * @Date 2022-03-02 20:29
 */
public class DFSTree {


    /**
     * @Author Jianrong.Chen
     * @Description 打印
     * @Date 2022-08-31 11:02
     * @Param [root]
     **/
    public static void dfsPrint(TreeNode root) {
        if (root != null) {
            dfsPrint(root.left);
            dfsPrint(root.right);
            System.out.println(root.val);
        }
    }


    /**
     * @Author Jianrong.Chen
     * @Description 前序遍历 迭代的方法
     * @Param [root]
     **/
    public static List<Integer> dfs0(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (null != node.right) {
                stack.push(node.right);
            }

            if (null != node.left) {
                stack.push(node.left);
            }
        }

        return result;
    }

    /**
     * @Author Jianrong.Chen
     * @Description 递归Recursive
     * @Date 2022-08-31 11:11
     * @Param [root, result]
     **/
    private static void inOrderRecursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            inOrderRecursive(root.left, result);
            inOrderRecursive(root.right, result);
        }
    }

    /**
     * @Author Jianrong.Chen
     * @Description 中序遍历
     * @Param [root]
     **/
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }


    /**
     * @Author Jianrong.Chen
     * @Description 中序遍历 迭代Iteration
     * @Date 2022-08-31 11:11
     * @Param [root, result]
     **/
    public static List<Integer> inOrderIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }


    /**
     * @Author Jianrong.Chen
     * @Description 后序遍历 迭代Iteration
     * @Date 2022-08-31 11:11
     * @Param [root, result]
     **/
    public static List<Integer> postOrderIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek(); // 用得很巧妙
            if (cur.right == null || cur.right == prev) {  // 用于回溯，这个更有意思
                cur = stack.pop();
                result.add(cur.val);
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return result;
    }
}