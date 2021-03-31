package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class ReverseListT206 {


    // 迭代
    public static ListNode iterativelyReverseList(ListNode head) {
        ListNode reverse = head;
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            if (head.next == null) {
                reverse = head;
            }
            head.next = prev;
            prev = head;
            head = next;
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

    // 反转链表的另一种写法
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }



}