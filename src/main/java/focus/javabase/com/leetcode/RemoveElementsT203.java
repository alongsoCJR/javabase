package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class RemoveElementsT203 {

    // [1,2,6,3,4,5,6]
    public static ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            int tmpVal = curr.val;
            if (tmpVal == val) {
                if (curr == head) {
                    head = curr.next;
                    prev = curr;
                } else if (curr.next == null) {
                    prev.next = null;
                    curr = null;
                    break;
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }


    // 参考 哨兵节点思想
    public ListNode removeElements1(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }


}