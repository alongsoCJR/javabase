package focus.javabase.com.algorithm.interview2;

import focus.javabase.com.leetcode.base.ListNode;

public class ReverseListNode {

    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        ListNode result = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                result = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return result;
    }


    public static ListNode reverse1(ListNode head) {
        ListNode prev = null;
        ListNode reverseHead = head;
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                reverseHead = head;
            }
            head.next = prev;
            prev = head;
            head = next;
        }
        return reverseHead;
    }

}