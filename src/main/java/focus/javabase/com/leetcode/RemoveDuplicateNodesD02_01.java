package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodesD02_01 {

    public static ListNode removeDuplicateNodes(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;
        Set<Integer> valSet = new HashSet<>();
        while (cur != null) {
            int val = cur.val;
            if (valSet.contains(val)) {
                // 跳过当前节点
                prev.next = cur.next;
            } else {
                valSet.add(val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}