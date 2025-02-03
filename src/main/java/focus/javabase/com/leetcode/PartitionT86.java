package focus.javabase.com.leetcode;


//Given the head of a linked list and a value x, partition it such that all node
//s less than x come before nodes greater than or equal to x.
//
// You should preserve the original relative order of the nodes in each of the t
//wo partitions.
//
//
// Example 1:
//
//
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
//
//
// Example 2:
//
//
//Input: head = [2,1], x = 2
//Output: [1,2]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 200].
// -100 <= Node.val <= 100
// -200 <= x <= 200
//
// Related Topics 链表 双指针
// 👍 873 👎 0


import focus.javabase.com.leetcode.base.ListNode;

public class PartitionT86 {

    public static ListNode partition(ListNode head, int x) {
        ListNode preltNode = new ListNode(-1);
        ListNode ltNode = preltNode;

        ListNode pregtNode = new ListNode(-1);
        ListNode gtNode = pregtNode;

        while (head != null) {
            int value = head.val;
            if (value < x) {
                ltNode.next = new ListNode(value);
                ltNode = ltNode.next;
            } else {
                gtNode.next = new ListNode(value);
                gtNode = gtNode.next;
            }
            head = head.next;
        }

        ltNode.next = pregtNode.next;
        return preltNode.next;
    }


    public static ListNode partition2(ListNode head, int x) {
        ListNode preltNode = new ListNode(-1);
        ListNode ltNode = preltNode;

        ListNode pregtNode = new ListNode(-1);
        ListNode gtNode = pregtNode;

        while (head != null) {
            int value = head.val;
            if (value < x) {
                ltNode.next = head;
                ltNode = ltNode.next;
            } else {
                gtNode.next = head;;
                gtNode = gtNode.next;
            }
            head = head.next;
        }
        gtNode.next = null;
        ltNode.next = pregtNode.next;
        return preltNode.next;
    }

}