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

    // 参考 （更好的处理了边界问题）
    public static ListNode middleNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}