package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PrintLevelOrderO32 {

    // 不分行打印
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // 分行打印
    public static List<List<Integer>> printLevelOrderDiffColumns(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(subList);
        }
        return result;
    }

    // 分行打印 之字形打印
    public static List<List<Integer>> printLevelOrderDiff(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isOdd = ((index % 2) == 1);
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOdd) {
                    subList.add(0, node.val);
                } else {
                    subList.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(subList);
            index++;
        }
        return result;
    }
}