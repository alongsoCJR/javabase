package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author chenjianrong-lhq
 * @Description 求树最左侧的节点
 * @Date 2020-10-13 23:15
 **/
public class GetLowerLeftTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(getLowerLeft(node));
    }

    public static Integer getLowerLeft(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();
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
        }

        // 取result中最后一个List，取List最左侧元素
        if (list.size() > 0) {
            return list.get(0);
        }
        return -1;
    }

}

