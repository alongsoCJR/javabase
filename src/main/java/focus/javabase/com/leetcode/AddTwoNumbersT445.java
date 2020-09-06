package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

import java.util.Stack;


//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself.
//
// Follow up:
//What if you cannot modify the input lists? In other words, reversing the lists
// is not allowed.
//
//
//
//Example:
//
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
//
// Related Topics 链表

// 7243+564=7807
public class AddTwoNumbersT445 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode head = new ListNode(0);
        ListNode node = head;

        int bitCount = 0;
        while (l1 != null || l2 != null || bitCount > 0) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + bitCount;
            if (sum >= 10) {
                sum = sum % 10;
                bitCount = 1;
            } else {
                bitCount = 0;
            }
            node.next = new ListNode(sum);
            node = node.next;
        }
        return reverse(head.next);
    }


    private static ListNode reverse(ListNode node) {
        ListNode head = null;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                head = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return head;
    }

    public static ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }

        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        int bitCount = 0;
        ListNode head = new ListNode(0);
        ListNode next = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || bitCount > 0) {
            int a = 0;
            int b = 0;
            if (!stack1.isEmpty()) {
                a = stack1.pop();
            }

            if (!stack2.isEmpty()) {
                b = stack2.pop();
            }

            int sum = a + b + bitCount;
            if (sum >= 10) {
                sum = sum % 10;
                bitCount = 1;
            } else {
                bitCount = 0;
            }
            head.next = new ListNode(sum);
            head.next.next = next;
            next = head.next;
        }
        return head.next;
    }
}