package focus.javabase.com.collection.tree;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author chenjianrong-lhq
 * @Description 二叉搜索树的建立
 * @Date 2020-09-02 13:26
 **/
public class BinarySearchTree {

    public static TreeNode create(int[] nums) {
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        return root;
    }

    private static TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (num > root.val) {
            // 插入右子树
            root.right = insert(root.right, num);
        } else {
            // 插入左子树
            root.left = insert(root.left, num);
        }
        return root;
    }

    // 搜素二叉树的中序遍历是 从小到大排序
    public static int[] inorder(TreeNode root) {
        List<Integer> list = new LinkedList();
        inorder(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }


}