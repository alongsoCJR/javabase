package focus.javabase.com.algorithm.interviewer;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Jianrong.Chen
 * @Description 层次遍历
 * @Date 2022-03-02 20:29
 */
public class BFSTree {

    public static List<Integer> bfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return result;
    }


    public static Integer levelTraverse(TreeNode root) {
        List<List<TreeNode>> ret = new ArrayList<>();
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int tmpSize = queue.size();
            List<TreeNode> level = new ArrayList<>();
            while (tmpSize != 0) {
                TreeNode tmp = queue.poll();

                level.add(tmp);
                if (null != tmp.left) {
                    queue.offer(tmp.left);
                }
                if (null != tmp.right) {
                    queue.offer(tmp.right);
                }
                tmpSize--;
                if (tmpSize == 0) {
                    ret.add(level);
                }
            }
        }
        return ret.get(ret.size() - 1).get(0).val;
    }


    public static Integer levelTraverseVal(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                result.add(temp.val);
                if (null != temp.left) {
                    queue.offer(temp.left);
                }

                if (null != temp.left) {
                    queue.offer(temp.right);
                }
            }

        }
        return result.get(result.size()-1);
    }
}