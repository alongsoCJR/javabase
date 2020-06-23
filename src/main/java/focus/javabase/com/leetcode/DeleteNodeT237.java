package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class DeleteNodeT237 {

    // 链表传参 有点像集合 只会对节点的引用（指针）进行修改
    public static void deleteNode(ListNode head, ListNode node) {
        ListNode prev = null;
        while (head != null) {
            if (head == node) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    head = head.next;
                }
                head = null;
                break;
            }
            prev = head;
            head = head.next;
        }
    }

    // 参考
    public static void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}