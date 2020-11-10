package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

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

    // 有问题
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

    // Hash法
    public static ListNode deleteDuplicates2(ListNode head) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (head != null) {
            int val = head.val;
            map.put(val, map.getOrDefault(val, 0) + 1);
            head = head.next;
        }

        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        // 也可以遍历一遍链表
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (1 == entry.getValue()) {
                cur.next = new ListNode(entry.getKey());
                cur = cur.next;
            }
        }
        return preHead.next;
    }

    // 参考
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 判断重复元素
            if (cur.next != null && cur.val == cur.next.val) {
                // 如果重复元素有多个就使用 while 循环遍历到重复元素的最后一个
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 此时 cur 指的是重复元素的最后一个数，使用 pre 将其断链
                pre.next = cur.next;
                cur = pre.next;
            } else {
                // 没有遇到重复元素就像后继续遍历
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    // 栈实现
}