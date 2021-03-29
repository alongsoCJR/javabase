package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author alongso.cjr
 * @Description TT 二面 输出树的最右侧元素
 * @Date 2021-03-29 21:04
 **/
public class GetRightNode {


    public static List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

}