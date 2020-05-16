package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

/**
 * @Author chenjianrong-lhq
 * @Description 判断列表是否有环
 * @Date 2020-05-16 17:27
 **/
public class HasCycleT141 {

    public static boolean hasCycle(ListNode head) {
        ListNode point1 = head;
        ListNode point2 = head;
        while (point1 != null && point2 != null) {
            point1 = point1.next;

            if (point2.next != null) {
                point2 = point2.next.next;
            } else {
                break;
            }

            if (point1 == point2) {
                return true;
            }
        }
        return false;
    }

    // 参考
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}