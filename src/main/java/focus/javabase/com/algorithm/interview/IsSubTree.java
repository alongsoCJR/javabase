package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;

/**
 * @Author chenjianrong-lhq
 * @Description 判断两颗树互为子树
 * @Date 2020-08-24 18:54
 **/
public class IsSubTree {


    //  root
//              1
//            2    3
//          4   5
//
//  sub
//            2
//          1
//        4
    public static boolean isSubTree(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) {
            return true;
        }
        if (root == null || sub == null) {
            return false;
        }

        // 不等则跳过该节点
        if (root.val != sub.val) {
            return isSubTree(root.left, sub) || isSubTree(root.right, sub);
        }
        // 相等则继续比较，遍历两个树的值是否一样
        return isSubTree(root.left, sub.left) && isSubTree(root.right, sub.right);
    }
}