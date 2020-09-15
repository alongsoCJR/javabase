package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class DeepestLeavesSumT1302 {

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
}