package focus.javabase.com.baseTest;

import focus.javabase.com.leetcode.base.ListNode;
import focus.javabase.com.leetcode.base.TreeNode;

/**
 * @Author Jianrong.Chen
 * @Description 转换类
 * @Date 2021-03-26 15:05
 **/
public class ConvertUtils {


    /**
     * @return focus.javabase.com.leetcode.base.ListNode
     * @Author Jianrong.Chen
     * @Description 数组转链表
     * @Date 2021-03-26 14:58
     * @Param [arrs]
     **/
    public static ListNode convertListNode(int[] arrs) {
        // 生成单向链表
        ListNode prevHead = new ListNode(-1);
        ListNode head = prevHead;
        for (int i = 0; i < arrs.length; i++) {
            head.next = new ListNode(arrs[i]);
            head = head.next;
        }
        return prevHead.next;
    }

    /**
     * @Author alongso.cjr
     * @Description 数组转二叉树（层次遍历转化）
     * @Date 2021-03-26 16:28
     * @Param [arrs]
     * @return focus.javabase.com.leetcode.base.TreeNode
     **/
    public static TreeNode convertTreeNode(Integer[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return null;
        }
        // 生成二叉树
        TreeNode root = buildTreeNode(arrs, 0);
        return root;
    }

    private static TreeNode buildTreeNode(Integer[] arrs, int index) {
        if (index >= arrs.length || arrs[index] == null) {
            return null;
        }
        TreeNode node = new TreeNode(arrs[index]);
        node.left = buildTreeNode(arrs, 2 * index + 1);
        node.right = buildTreeNode(arrs, 2 * index + 2);
        return node;
    }
}