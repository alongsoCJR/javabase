package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

import java.util.HashMap;
import java.util.Map;

public class IsPalindromeNodeT234 {

    // 哈希表(也能用arrayList实现)  时间复杂度:O(n) 空间复杂度：O(n)
    public static boolean isPalindrome(ListNode head) {
        Map<Integer, Integer> nodeMap = new HashMap<>();
        int index = 0;
        while (head != null) {
            nodeMap.put(++index, head.val);
            head = head.next;
        }

        int len = nodeMap.size();
        for (int i = 1; i <= len / 2; i++) {
            Integer val1 = nodeMap.get(i);
            Integer val2 = nodeMap.get(len - i + 1);
            if (!val1.equals(val2)) {
                return false;
            }
        }
        return true;
    }

    // 参考
    public static boolean isPalindrome1(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}