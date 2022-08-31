package focus.javabase.com.algorithm.interviewer;

import focus.javabase.com.leetcode.base.ListNode;

public class ReverseListNode {

    public static ListNode reverse(ListNode head) {
        ListNode node = head;
        ListNode reverse = head;
        ListNode prev = null;
        while (node != null) {
            ListNode cur = node;
            if (cur.next == null) {
                reverse = cur;
            }
            node = node.next;
            cur.next = prev;
            prev = cur;
        }
        return reverse;
    }


    public static ListNode reverse1(ListNode head) {
        ListNode cur = head;
        ListNode reverse = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                reverse = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return reverse;
    }

}