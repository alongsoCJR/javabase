package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Jianrong.Chen
 * @Description zj 根据前序中序输出后序
 * @Date 2022-09-02 11:05
 */
public class TreeNodePostOrder {

    public static List<Integer> getPostOrder(List<Integer> fronts, List<Integer> middles) {

        // 获取整颗二叉树
        TreeNode root = getTreeNode(fronts, middles);

        // 然后后序遍历二叉树
        List<Integer> result = new ArrayList();
        dfs(root, result);

        return result;
    }

    /**
     * @Author Jianrong.Chen
     * @Description 后序遍历
     * @Date 10:16
     * @Param [root, result]
     **/
    private static void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);
    }

    /**
     * @Author Jianrong.Chen
     * @Description 获取整颗二叉树
     * @Date 2022-09-07 10:17
     * @Param [fronts, middles]
     **/
    private static TreeNode getTreeNode(List<Integer> fronts, List<Integer> middles) {
        // 加一个非空判断
        if (fronts.size() == 0 || middles.size() == 0) {
            return null;
        }
        // 获取第一个节点
        int value = fronts.get(0);
        if (fronts.size() == 1 || middles.size() == 1) {
            return new TreeNode(value);
        }
        TreeNode root = new TreeNode(value);
        int index = middles.indexOf(value);
        List<Integer> firstM = middles.subList(0, index);
        List<Integer> lastM = middles.subList(index + 1, middles.size());

        // 构造前序遍历
        List<Integer> firstF = getByMiddle(fronts, firstM);
        List<Integer> lastF = getByMiddle(fronts, lastM);

        // 获取节点的左节点
        root.left = getTreeNode(firstF, firstM);
        // 获取节点的右节点
        root.right = getTreeNode(lastF, lastM);
        return root;
    }

    /**
     * @Author Jianrong.Chen
     * @Description 根据中序的数据获取前序的数据（需保存顺序）
     * @Date 2022-09-07 10:11
     * @Param [fronts, middles]
     **/
    private static List<Integer> getByMiddle(List<Integer> fronts, List<Integer> middles) {
        Set<Integer> set = new HashSet<>(middles);
        List<Integer> result = new ArrayList<>();
        for (Integer item : fronts) {
            if (set.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}