package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class ReverseListT206 {


    // 迭代
    public static ListNode iterativelyReverseList(ListNode head) {
        ListNode reverse = head;
        ListNode prev = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            if (head.next == null) {
                reverse = head;
            }
            head.next = prev;
            prev = head;
            head = cur;
        }
        return reverse;
    }


    // 递归
    public static ListNode recursivelyReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = recursivelyReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

}