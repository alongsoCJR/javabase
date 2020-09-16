package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class DeepestLeavesSumT1302 {

    private static int max = -1;
    private static int result = 0;

    public static int deepestLeavesSum(TreeNode root) {
        Map<TreeNode, Integer> deepMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        deepMap.put(root, deepMap.getOrDefault(root, 0));
        int deepestLeavesSum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                deepMap.put(node.right, deepMap.get(node) + 1);
            }

            if (node.left != null) {
                stack.push(node.left);
                deepMap.put(node.left, deepMap.get(node) + 1);
            }
        }
        // 找出最大的深度
//        int deepest = 0;
        Set<Map.Entry<TreeNode, Integer>> entrySet = deepMap.entrySet();
//        for (Map.Entry<TreeNode, Integer> entry : entrySet) {
//            deepest = Math.max(entry.getValue(), deepest);
//        }

        int deepest = Collections.max(deepMap.values());

        // 找到对应的val
        for (Map.Entry<TreeNode, Integer> entry : entrySet) {
            if (entry.getValue() == deepest) {
                TreeNode node = entry.getKey();
                deepestLeavesSum += node.val;
            }
        }

        Integer max = deepMap.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();

        List<TreeNode> listOfMax = deepMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(max))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        deepestLeavesSum = listOfMax.stream().mapToInt(x -> (x.val)).sum();
        return deepestLeavesSum;
    }

    // DFS 深度遍历
    // 对于node  dep(node)<max  continue
    //          dep(node)=max sum+=node.val
    //          dep(node)>max sum=node.val
    public static int deepestLeavesSum0(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        Map<TreeNode, Integer> deepMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        root.dep = 0;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                node.right.dep = node.dep + 1;
                stack.push(node.right);
            }

            if (node.left != null) {
                node.left.dep = node.dep + 1;
                stack.push(node.left);
            }

            if (node.dep < max) {
                continue;
            } else if (node.dep > max) {
                max = node.dep;
                result = node.val;
            } else {
                result += node.val;
            }
        }
        return result;
    }

    // 参考
    public static int deepestLeavesSum1(TreeNode root) {
        dfs(root, 0);
        return result;
    }


    // 对于node  dep(node)<max  continue
    //          dep(node)=max sum+=node.val
    //          dep(node)>max sum=node.val
    private static void dfs(TreeNode root, int dep) {
        if (root != null) {
            if (dep > max) {
                max = dep;
                result = root.val;
            } else if (dep == max) {
                result += root.val;
            }
            dfs(root.left, dep + 1);
            dfs(root.right, dep + 1);
        }
    }

    // 层次遍历更简单
    public static int deepestLeavesSum2(TreeNode root) {
        return bfs(root, 0);
    }

    private static int bfs(TreeNode root, int dep) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int sum = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return sum;
    }
}