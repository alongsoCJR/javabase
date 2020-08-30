package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * @Author chenjianrong-lhq
 * @Description ks面试题
 * @Date 2020-08-19 09:36
 **/
public class PrintTreePaths {


    public static List print(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        Stack<Integer> stack = new Stack();
        // 遍历左子树 [2,4] [2,5]
        List<Stack<Integer>> leftResult = print(root.left);
        // 遍历右子树 [3]
        List<Stack<Integer>> rightResult = print(root.right);

        // 放入结果集
        if (leftResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (Stack<Integer> s : leftResult) {
                s.push(root.val);
                result.add(s);
            }
        }

        if (rightResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (Stack<Integer> s : rightResult) {
                s.push(root.val);
                result.add(s);
            }
        }

        if (leftResult.size() == 0 && rightResult.size() == 0) {
            stack.push(root.val);
            result.add(stack);
        }
        return result;
    }

    public static List print1(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        List<Integer> numsList = new ArrayList();
        // 遍历左子树 [2,4] [2,5] [2]
        List<List<Integer>> leftResult = print1(root.left);
        // 遍历右子树 [3]
        List<List<Integer>> rightResult = print1(root.right);

        // 放入结果集
        if (leftResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (List list : leftResult) {
                List subList = new ArrayList();
                subList.add(root.val);
                subList.addAll(list);
                result.add(subList);
            }
        }

        if (rightResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (List list : rightResult) {
                List subList = new ArrayList();
                subList.add(root.val);
                subList.addAll(list);
                result.add(subList);
            }
        }
        // 叶子节点
        if (leftResult.size() == 0 && rightResult.size() == 0) {
            numsList.add(root.val);
            result.add(numsList);
        }
        return result;
    }

    // 递归
    public static List<List<Integer>> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        searchTreePaths(root, new LinkedList<>(), paths);
        return paths;
    }

    private static void searchTreePaths(TreeNode root, List<Integer> path, List<List<Integer>> paths) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                List<Integer> left = new LinkedList<>(path);
                List<Integer> right = new LinkedList<>(path);
                searchTreePaths(root.left, left, paths);
                searchTreePaths(root.right, right, paths);
            }
        }
    }

    // 迭代实现 参考官方
}