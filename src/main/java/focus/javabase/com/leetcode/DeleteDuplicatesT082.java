package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

/**
 * @author chenjianrong
 */
public class DeleteDuplicatesT082 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (prev != null && cur.val == prev.val) {
                // 元素相等
                prev.next = cur.next;
            } else {
                // 元素不等
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    public static ListNode deleteDuplicates0(ListNode head) {
        ListNode curNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (curNode != null) {
            boolean needDeleted = false;
            nextNode = curNode.next;
            if (nextNode != null) {
                needDeleted = (curNode.val == nextNode.val);
            }

            if (!needDeleted) {
                prevNode = curNode;
            } else {
                ListNode needDeletedNode = curNode;
                int val = needDeletedNode.val;
                while (needDeletedNode != null && needDeletedNode.val == val) {
                    needDeletedNode = needDeletedNode.next;
                    // 释放内存
                }

                if (prevNode == null) {
                    prevNode = needDeletedNode;
                    head = prevNode;
//                    nextNode = needDeletedNode;
                } else {
                    prevNode.next = needDeletedNode;
                }

                // else if (needDeletedNode != null) {
                nextNode = needDeletedNode;
            }
            curNode = nextNode;
        }
        return head;
    }


    // 参考
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode curNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (curNode != null) {
            boolean needDeleted = false;
            nextNode = curNode.next;
            if (nextNode != null) {
                needDeleted = (curNode.val == nextNode.val);
            }

            if (!needDeleted) {
                prevNode = curNode;
                curNode = nextNode;
            } else {
                ListNode needDeletedNode = curNode;
                int val = needDeletedNode.val;
                while (needDeletedNode != null && needDeletedNode.val == val) {
                    nextNode = needDeletedNode.next;
                    // 释放内存
                    needDeletedNode = null;
                    needDeletedNode = nextNode;
                }

                if (prevNode == null) {
                    head = nextNode;
//                    head = prevNode;
//                    nextNode = needDeletedNode;
                } else {
                    prevNode.next = nextNode;
                }

                // else if (needDeletedNode != null) {
//                nextNode = needDeletedNode;
                curNode = nextNode;
            }
        }
        return head;
    }
}