package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;


/**
 * @Author chenjianrong-lhq
 * @Description 统计叶子节点的个数
 * @Date 2020-09-25 18:08
 **/
public class CountLeafs {

    public static int countLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaf(root.right) + countLeaf(root.left);
    }
}