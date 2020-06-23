package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class MiddleNodeT876 {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
                continue;
            }
            slow = slow.next;
        }
        return slow;
    }
}