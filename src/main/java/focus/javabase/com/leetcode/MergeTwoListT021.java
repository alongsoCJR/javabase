package focus.javabase.com.leetcode;


//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表


public class MergeTwoListT021 {

    public static ListNode list = new ListNode(0);

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 如何初始化呢 ？
        ListNode head = null;
        ListNode result = list;
        // 迭代
        while (l1 != null && l2 != null) {
            if (l1.next != null && l2.next != null) {
                // 比较大小，取最小
                if (l1.val > l2.val) {
                    result.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    result.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                result = result.next;
            }

            if (head == null && result != list) {
                head = result;
            }

            if (l1.next == null || l2.next == null) {
                if (l1.next == null) {
                    if (l1.val > l2.val) {
                        result.next = new ListNode(l2.val);
                        l2 = l2.next;
                    } else {
                        result.next = new ListNode(l1.val);
                        l1 = l1.next;
                    }
                    result = result.next;
                } else {
                    if (l2.val > l1.val) {
                        result.next = new ListNode(l1.val);
                        l1 = l1.next;
                    } else {
                        result.next = new ListNode(l2.val);
                        l2 = l2.next;
                    }
                    result = result.next;
                }
            }

            if (head == null && result != list) {
                head = result;
            }
        }

        if (l1 == null) {
            result.next = l2;
        }

        if (l2 == null) {
            result.next = l1;
        }
        return head;
    }

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //  输入：1->2->4, 1->3->4
    //  输出：1->1->2->3->4->4
    // 漂亮啊！递归实现
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        if (l1.val > l2.val) {
            result = new ListNode(l2.val);
            result.next = mergeTwoLists2(l1, l2.next);
        } else {
            result = new ListNode(l1.val);
            // 递归
            result.next = mergeTwoLists2(l1.next, l2);
        }
        return result;
    }
    /**
     *else if (l1.next == null) {
     *                 if (l1.val > l2.val) {
     *                     result.next = new ListNode(l2.val);
     *                     l2 = l2.next;
     *                     result = result.next;
     *                 } else {
     *                     result.next = l1;
     *                     result = result.next;
     *                     result.next = l2;
     *                     break;
     *                 }
     *
     *             } else if (l2.next == null) {
     *                 if (l2.val > l1.val) {
     *                     result.next = new ListNode(l1.val);
     *                     l1 = l1.next;
     *                     result = result.next;
     *                 } else {
     *                     result.next = l2;
     *                     result = result.next;
     *                     result.next = l1;
     *                     break;
     *                 }
     *             }
     **/
}

