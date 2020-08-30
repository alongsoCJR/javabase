package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSumO34 {

    // 判断是否含有
    public static boolean pathSum0(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return pathSum0(root.left, sum - root.val) || pathSum0(root.right, sum - root.val);
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        // 退出递归
        if (root == null) {
            return result;
        }

        // 找到一条路径，返回
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> subList = new LinkedList<>();
            subList.add(root.val);
            result.add(subList);
            return result;
        }

        // 合并左右子树的结果
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        if (left.size() > 0) {
            for (List<Integer> list : left) {
                list.add(0, root.val);
                result.add(list);
            }
        }
        if (right.size() > 0) {
            for (List<Integer> list : right) {
                list.add(0, root.val);
                result.add(list);
            }
        }
        return result;
    }

    public static List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        pathSumWithList(root, sum, new LinkedList<>(), result);
        return result;
    }


    public static void pathSumWithList(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        // 为空，退出递归
        if (root == null) {
            return;
        }
        //  先记录路径
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            // 找到一条路径，添加进集合
            result.add(path);
        } else {
            // 遍历左右子数
            List<Integer> left = new LinkedList<>(path);
            List<Integer> right = new LinkedList<>(path);
            pathSumWithList(root.left, sum - root.val, left, result);
            pathSumWithList(root.right, sum - root.val, right, result);
        }
    }


}