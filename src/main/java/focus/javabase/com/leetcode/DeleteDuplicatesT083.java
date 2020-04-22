package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class DeleteDuplicatesT083 {

    // 1->1->2->3->3
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            // 比较
            if (prev != null &&
                    prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}