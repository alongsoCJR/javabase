package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.*;

/**
 * @Author Jianrong.Chen
 * @Description yqg
 * @Date 2021-03-18 11:30
 **/
public class GetMaxTreeBranch {

    public static List<List<Integer>> getDBranchByRecursion(TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        getAllBranch(root, new LinkedList<>(), paths);
        return paths;
    }

    private static void getAllBranch(TreeNode root, List<Integer> path, List<List<Integer>> paths) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                getAllBranch(root.left, new LinkedList<>(path), paths);
                getAllBranch(root.right, new LinkedList<>(path), paths);
            }
        }
    }


    public static List<List<Integer>> getBBranchByIteration(TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.offer(root);
        }
        List<Integer> list = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            paths.add(list);
        }
        return paths;
    }


    public static void dfsByRecursion(TreeNode root) {
        // 中序遍历
        if (root != null) {
            System.out.print(root.val + " ");
            dfsByRecursion(root.left);
            dfsByRecursion(root.right);
        }
    }

    // 迭代 8 3 1 6 4 7 10 14 13
    public static void dfsByIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }


}