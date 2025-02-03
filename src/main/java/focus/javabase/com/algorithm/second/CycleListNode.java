package focus.javabase.com.algorithm.second;

import focus.javabase.com.leetcode.base.ListNode;

import java.util.HashSet;
import java.util.Set;

public class CycleListNode {


    public static Boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }


    public static Boolean isCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    // 假设头节点到入口是x，从入口到相遇点是y，那么相遇时候慢节点就走了x+y，
    // 快节点就是走了2（x+y），那么就说明慢节点从相遇点再走x+y就会回到相遇点；
    // 假设两个慢节点一个从头节点出发，一个从相遇点出发，都走x+y就会在相遇点相遇，
    // 那么都少走y距离呢，就会在走x距离时相遇.
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meetingNode = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetingNode = slow;
                break;
            }
        }

        if (meetingNode == null) {
            return meetingNode;
        }

        fast = fast.next;
        int count = 1;
        while (meetingNode != fast) {
            fast = fast.next;
            count++;
        }

        slow = head;
        fast = head;
        for (int i = 0; i < count; i++) {
            slow = slow.next;
        }
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    public static ListNode detectCycle01(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

}