package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author chenjianrong-lhq
 * @Description 二叉数的镜像
 * @Date 2020-08-22 10:56
 **/
public class MirrorTreeNodeO027 {

    // 递归
    public static TreeNode mirrorByRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode mirrorTree = new TreeNode(root.val);
        if (root.left != null) {
            mirrorTree.right = mirrorByRecursion(root.left);
        }

        if (root.right != null) {
            mirrorTree.left = mirrorByRecursion(root.right);
        }
        return mirrorTree;
    }

    // 递归-参考
    public TreeNode invertTreeByRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTreeByRecursion(root.right);
        TreeNode left = invertTreeByRecursion(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


    // 迭代
    public static TreeNode mirrorByIteration(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (node.left != null || node.right != null) {
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;
            }

        }
        return root;
    }

    // 迭代-参考
    public TreeNode invertTreeByIteration(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

}