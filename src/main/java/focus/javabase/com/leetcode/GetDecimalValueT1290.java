package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

public class GetDecimalValueT1290 {

    // 数组 位运算
    public static int getDecimalValue(ListNode head) {
        int[] nums = new int[30];
        int t = 0;
        while (head != null) {
            nums[t++] = head.val;
            head = head.next;
        }
        int ret = 0;
        for (int i = t - 1; i >= 0; i--) {
            ret += (nums[i] << (t - 1 - i));
        }
        return ret;
    }


    // 反转 位运算
    public static int getDecimalValue1(ListNode head) {
        ListNode reverse = reverseListNode(head);
        int bit = 0;
        int ret = 0;
        while (reverse != null) {
            ret += (reverse.val << bit);
            reverse = reverse.next;
            bit++;
        }
        return ret;
    }

    // 反转 把head的结构改了
    private static ListNode reverseListNode(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (head != null) {
            cur = head.next;
            head.next = prev;
            prev = head;
            head = cur;
        }

        return prev;
    }
}