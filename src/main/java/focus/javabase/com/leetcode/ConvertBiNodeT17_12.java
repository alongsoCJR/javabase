package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

public class ConvertBiNodeT17_12 {


    public static TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);
        convertBiNode(root, head);
        return head.right;
    }

    private static TreeNode convertBiNode(TreeNode root, TreeNode head) {
        if (root != null) {
            head = convertBiNode(root.left, head);
//            (root.val);

            root.left = null;
            head.right = root;
            head = root;


            head = convertBiNode(root.right, head);
        }
        return head;
    }


    public static TreeNode print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
        return root;
    }

    public static TreeNode copyTree(TreeNode root) {
        TreeNode node = null;
        if (root != null) {
            node = new TreeNode(root.val);
            TreeNode left = copyTree(root.left);
            TreeNode right = copyTree(root.right);
            node.left = left;
            node.right = right;
        }
        return node;
    }
}