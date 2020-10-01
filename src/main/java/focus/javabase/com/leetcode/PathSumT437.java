package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathSumT437 {

    // 广度优先遍历
    public int pathSum(TreeNode root, int sum) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        bfs(root, list);
        for (Integer num : list) {
            if (num == sum) {
                ans++;
            }
        }
        return ans;
    }


    // 1,2,3,4
    // 1
    // 2,3     4,3
    // 6,7,4
    public void bfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<List<Integer>> listQueue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        listQueue.add(list);
        while (!queue.isEmpty()) {
            TreeNode subNode = queue.poll();
            List<Integer> subList = listQueue.poll();
            result.addAll(subList);

            if (subNode.left != null) {
                // 推入左子树
                queue.offer(subNode.left);

                // 推入List
                List<Integer> left = new ArrayList<>();
                for (Integer num : subList) {
                    left.add(num + subNode.left.val);
                }
                left.add(subNode.left.val);
                listQueue.offer(left);
            }

            if (subNode.right != null) {
                // 推入右子树
                queue.offer(subNode.right);

                // 推入List
                List<Integer> right = new ArrayList<>();
                for (Integer num : subList) {
                    right.add(num + subNode.right.val);
                }
                right.add(subNode.right.val);
                listQueue.offer(right);

            }

        }
    }

    // 深度优先遍历
    public int pathSum0(TreeNode root, int sum) {
        return dfs(root, sum, new LinkedList<Integer>());
    }

    private int dfs(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return 0;
        }
        List<Integer> subList = new ArrayList<>();
        if (list.size() > 0) {
            for (Integer num : list) {
                subList.add(num + root.val);
            }
        }
        subList.add(root.val);
        int count = 0;
        for (Integer num : subList) {
            if (num == sum) {
                count++;
            }
        }
        return count + dfs(root.left, sum, subList) + dfs(root.right, sum, subList);
    }
}