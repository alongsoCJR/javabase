package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.TreeNode;

import java.util.*;

// 给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
public class IsSymmetricT101 {


    // 不能处理 null的情况
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> deque = new ArrayDeque();
        addStack(root.left, stack);
        addQuene(root.right, deque);
        if (stack.size() != deque.size()) {
            return false;
        }
        while (!stack.empty()) {
            int m = stack.pop();
            if (m != deque.poll()) {
                return false;
            }
        }
        return true;
    }

    // 迭代
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> listQ = new LinkedList<>();
        listQ.add(root.left);
        listQ.add(root.right);
        while (!listQ.isEmpty()) {
            TreeNode p = listQ.poll();
            TreeNode q = listQ.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            listQ.add(p.left);
            listQ.add(q.right);
            listQ.add(p.right);
            listQ.add(q.left);
        }
        return true;
    }


    // 递归
    public static boolean isSymmetric2(TreeNode root) {
        return false;
    }

    public static boolean checkSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val;
    }

    // 先序遍历 递归
    public static void addStack(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        addStack(root.left, stack);
        stack.push(root.val);
        addStack(root.right, stack);

    }


    public static void addQuene(TreeNode root, ArrayDeque<Integer> deque) {
        if (root == null) {
            return;
        }
        addQuene(root.left, deque);
        deque.offer(root.val);
        addQuene(root.right, deque);

    }


    //深度遍历 = 先序遍历（栈）
    public static void dfsPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            System.out.print(cur.val + " ");
        }
        System.out.println();

    }


    // 广度遍历 = 层级遍历（队列）Breadth-First Search
    public static void bfsPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }
}