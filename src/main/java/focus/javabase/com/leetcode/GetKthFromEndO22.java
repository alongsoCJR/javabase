package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class GetKthFromEndO22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode prev = head;
        ListNode curr = head;
        int distance = 0;
        while (curr != null) {
            if (distance < k) {
                distance++;
                curr = curr.next;
            }

            if (distance == k) {
                prev = prev.next;
                curr = curr.next;
            }
        }

        if (distance < k) {
            System.err.println("Error k");
            return null;
        }
        return prev;
    }
}