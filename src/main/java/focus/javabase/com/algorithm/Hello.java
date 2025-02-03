package focus.javabase.com.algorithm;


import focus.javabase.com.leetcode.base.ListNode;

public class Hello {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        ListNode reverse = reverseList(listNode, 7);
    }


    public static ListNode reverseList(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 找到第n-1个节点
        ListNode prev = dummy;
        for (int i = 0; i < n - 1; i++) {
            if (prev != null) {
                prev = prev.next;
            }
        }
        // 反转第n个节点之后的链表
        ListNode reverseNode = null;
        if (prev != null && prev.next != null) {
            reverseNode = reverse(prev.next);
            // 拼装
            prev.next = reverseNode;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode reverseHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                reverseHead = cur;
            }

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return reverseHead;
    }

}
