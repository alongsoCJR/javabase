package focus.javabase.com.algorithm.interview2;

import focus.javabase.com.leetcode.base.ListNode;

public class DupListNode {


    // 异常case [1,1,1]
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = cur;
        while (cur != null) {
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return head;
    }


    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (prev != null && prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}