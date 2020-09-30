package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PathSumT113 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        pathByRecursion(result, root);

        int count = 0;
        Iterator<List<Integer>> iterator = result.iterator();
        while (iterator.hasNext()) {
            count = 0;
            List<Integer> list = iterator.next();
            for (Integer num : list) {
                count += num;
            }
            if (count != sum) {
                iterator.remove();
            }
        }
        return result;
    }

    public void pathByRecursion(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            List list = new LinkedList();
            list.add(root.val);
            result.add(list);
            return;
        }

        List<List<Integer>> left = new LinkedList<>();
        List<List<Integer>> right = new LinkedList<>();
        pathByRecursion(left, root.left);
        pathByRecursion(right, root.right);
        if (left.size() > 0) {
            // 添加至第一个元素
            for (List list : left) {
                list.add(0, root.val);
            }
            result.addAll(left);
        }

        if (right.size() > 0) {
            // 添加至第一个元素
            for (List list : right) {
                list.add(0, root.val);
            }
            result.addAll(right);
        }

    }


    public List<List<Integer>> pathSum0(TreeNode root, int sum) {
        List<List<Integer>> result = binaryTreePaths(root);
        Iterator<List<Integer>> iterator = result.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count = 0;
            List<Integer> list = iterator.next();
            for (Integer num : list) {
                count += num;
            }
            if (count != sum) {
                iterator.remove();
            }
        }
        return result;
    }

    public static List<List<Integer>> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        searchTreePaths(root, new LinkedList<>(), paths);
        return paths;
    }

    private static void searchTreePaths(TreeNode root, List<Integer> path, List<List<Integer>> paths) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                List<Integer> left = new LinkedList<>(path);
                List<Integer> right = new LinkedList<>(path);
                searchTreePaths(root.left, left, paths);
                searchTreePaths(root.right, right, paths);
            }
        }
    }


    public List<List<Integer>> path1(TreeNode root, int sum) {
        List<List<Integer>> paths = new LinkedList<>();
        searchTreePaths(root, new LinkedList<>(), paths, sum);
        return paths;
    }

    private void searchTreePaths(TreeNode root, List<Integer> path, List<List<Integer>> paths, int sum) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null && sum == root.val) {
                paths.add(path);
            } else {
                List<Integer> left = new LinkedList<>(path);
                List<Integer> right = new LinkedList<>(path);
                searchTreePaths(root.left, left, paths, sum - root.val);
                searchTreePaths(root.right, right, paths, sum - root.val);
            }
        }
    }
}