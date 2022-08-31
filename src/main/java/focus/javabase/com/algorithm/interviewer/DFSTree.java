package focus.javabase.com.algorithm.interviewer;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        dfsPrint(root.left);
        dfsPrint(root.right);
    }


    /**
     * @Author Jianrong.Chen
     * @Description 返回
     * @Param [root]
     **/
    public static List<Integer> dfs0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsRecursive(root, result);
        return result;
    }

    /**
     * @Author Jianrong.Chen
     * @Description 递归Recursive
     * @Date 2022-08-31 11:11
     * @Param [root, result]
     **/
    private static void dfsRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        dfsRecursive(root.left, result);
        dfsRecursive(root.right, result);
    }

    /**
     * @Author Jianrong.Chen
     * @Description 迭代Iteration
     * @Date 2022-08-31 11:11
     * @Param [root, result]
     **/
    private static void dfsIteration(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


    /**
     * @Author Jianrong.Chen
     * @Description 返回
     * @Param [root]
     **/
    public static List<Integer> dfs1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsIteration(root, result);
        return result;
    }

}