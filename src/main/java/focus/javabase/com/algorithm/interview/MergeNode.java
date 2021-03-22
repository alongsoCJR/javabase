package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.ListNode;

/**
 * @Author Jianrong.Chen
 * @Description gsx一面  多个升序链表数组 合并 到一个升序链表 并返回
 * @Date 2021-03-22 15:22
 **/
public class MergeNode {

    public static ListNode mergeNodeArray(ListNode[] nodes) {
        if (nodes == null) {
            return null;
        }

        if (nodes.length == 1) {
            return nodes[0];
        }

        ListNode mergeNode = null;
        // 遍历链表数组
        for (int i = 0; i < nodes.length; i++) {
            mergeNode = mergeTwoNode1(nodes[i], mergeNode);
        }

        // 返回结果
        return mergeNode;

    }

    public static ListNode mergeTwoNode(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode cur = new ListNode(0);
        root.next = cur;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return root.next.next;
    }

    public static ListNode mergeTwoNode1(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1);
        ListNode cur = prevHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return prevHead.next;
    }
}