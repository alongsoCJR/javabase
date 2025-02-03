package focus.javabase.com.algorithm.interview2;


import focus.javabase.com.leetcode.base.ListNode;

//单向链表删除倒数第n个节点，返回头结点
//输入:Node head，int n
//输出:Node head
//
//例子：1-2-3-4-5，删除倒数第2节点
//输出：1-2-3-5  滴滴面试题
public class RemoveNthFromEndT19 {

    public static void main(String[] args) {

        //
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = deleteNode2(head, 2);

    }


    public static ListNode deleteNode2(ListNode head, int n) {
        // 验证n和head
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 遍历删除第n个节点
        int i = 1;
        int index = len - n + 1;

        // 处理单个的情况
        if (index == 1) {
            return head.next;
        }

        ListNode node = head;
        ListNode prev = node;
        while (node != null) {
            ListNode next = node.next;
            // 删除第n个节点
            if (i == index) {
                prev.next = next;
            } else {
                prev = node;
            }
            node = next;
            i++;
        }
        return head;

    }


    public static ListNode deleteNode1(ListNode head, int n) {
        // 验证n
//        ListNode slow = head;
//        ListNode fast = head;
//
//        for (int i = 0; i < n; i++) {
//            fast = fast.next;
//        }
//        while (fast != null) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//        slow.next = slow.next.next;
//        return head;  // 没法处理head指向null的问题，或者删除第一个的问题


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode deleteNode(ListNode head, int n) {
        // 验证n

        // 优先反转链表
        ListNode reverseNode = reverse(head);
        if (n == 1) {
            return reverse(reverseNode.next);
        }

        // 遍历删除第n个节点
        int i = 1;
        ListNode node = reverseNode;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            // 删除第n个节点
            if (i == n) {
                prev.next = next;
            }
            prev = node;
            node = next;
            i++;
        }
        // 再反转reverseNode
        return reverse(reverseNode);
    }


    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode result = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                result = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return result;
    }
}