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

    // 思路不清晰，走了很多冤枉路
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
            // 为什么还要判断l1.next 和 l2.next呢？迭代不熟悉啊
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
        // 参考官方代码，结果的返回
    }

    // 官方提供的迭代
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode prevhead = prev;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prevhead.next;
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

