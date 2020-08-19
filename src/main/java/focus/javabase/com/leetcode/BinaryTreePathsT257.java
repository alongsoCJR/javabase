package focus.javabase.com.leetcode;


//Given a binary tree, return all root-to-leaf paths.
//
// Note: A leaf is a node with no children.
//
// Example:
//
//
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)


import focus.javabase.com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinaryTreePathsT257 {


    public static List binaryTreePaths(TreeNode root) {
        List<Stack<Integer>> pathList = BinaryTreePathsT257.binaryTreePaths1(root);
        List<String> result = new ArrayList<>();
        for (Stack<Integer> stack : pathList) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                if (sb.length() == 0) sb.append(stack.pop());
                else sb.append("->").append(stack.pop());
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static List binaryTreePaths1(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<Stack<Integer>> result = new ArrayList();
        Stack<Integer> stack = new Stack();
        // 遍历左子树 [2,4] [2,5]
        List<Stack<Integer>> leftResult = binaryTreePaths1(root.left);
        // 遍历右子树 [3]
        List<Stack<Integer>> rightResult = binaryTreePaths1(root.right);

        // 放入结果集
        if (leftResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (Stack<Integer> s : leftResult) {
                s.push(root.val);
                result.add(s);
            }
        }

        if (rightResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (Stack<Integer> s : rightResult) {
                s.push(root.val);
                result.add(s);
            }
        }

        if (leftResult.size() == 0 && rightResult.size() == 0) {
            stack.push(root.val);
            result.add(stack);
        }
        return result;
    }

    public static List binaryTreePaths2(TreeNode root) {
        List<List<Integer>> pathList = binaryTreePaths3(root);
        List<String> result = new ArrayList<>();
        for (List<Integer> stack : pathList) {
            StringBuilder sb = new StringBuilder();
            Iterator iterator = stack.iterator();
            while (iterator.hasNext()) {
                if (sb.length() == 0) sb.append(iterator.next());
                else sb.append("->").append(iterator.next());
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static List binaryTreePaths3(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        List<Integer> numsList = new ArrayList();
        // 遍历左子树 [2,4] [2,5] [2]
        List<List<Integer>> leftResult = binaryTreePaths3(root.left);
        // 遍历右子树 [3]
        List<List<Integer>> rightResult = binaryTreePaths3(root.right);

        // 放入结果集
        if (leftResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (List list : leftResult) {
                List subList = new ArrayList();
                subList.add(root.val);
                subList.addAll(list);
                result.add(subList);
            }
        }

        if (rightResult.size() > 0) {
            // 将当前元素加至下标为0的位置
            for (List list : rightResult) {
                List subList = new ArrayList();
                subList.add(root.val);
                subList.addAll(list);
                result.add(subList);
            }
        }
        // 叶子节点
        if (leftResult.size() == 0 && rightResult.size() == 0) {
            numsList.add(root.val);
            result.add(numsList);
        }
        return result;
    }
}

