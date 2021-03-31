package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.*;


/**
 * @Author chenjianrong-lhq
 * @Description ks
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

    // 层次遍历 迭代实现 参考官方
    public static List<List<Integer>> binaryTreePaths0(TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        if (root == null) {
            return paths;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<List<Integer>> listQueue = new LinkedList<>();
        nodeQueue.offer(root);

        List<Integer> rootList = new LinkedList<>();
        rootList.add(root.val);
        listQueue.offer(rootList);
        while (!nodeQueue.isEmpty()) {
            List<Integer> list = listQueue.poll();
            TreeNode node = nodeQueue.poll();
            if (node.left == null && node.right == null) {
                paths.add(new LinkedList<>(list));
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);

                    List<Integer> leftList = new LinkedList<>(list);
                    leftList.add(node.left.val);
                    listQueue.offer(leftList);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);

                    List<Integer> rightList = new LinkedList<>(list);
                    rightList.add(node.right.val);
                    listQueue.offer(rightList);
                }
            }
        }
        return paths;
    }
}