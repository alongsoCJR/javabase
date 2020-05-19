package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;

/**
 * @Author chenjianrong-lhq
 * @Description 相交链表
 * @Date 2020-05-18 13:48
 **/
public class GetIntersectionNodeT160 {

    //[4,1,8,4,5]  [5,0,1,8,4,5]
    // 暴力法
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode keyA = headA;
        ListNode keyB = null;
        while (keyA != null) {
            keyB = headB;
            while (keyB != null) {
                if (keyA == keyB) {
                    return keyB;
                }
                keyB = keyB.next;
            }
            keyA = keyA.next;
        }
        return null;
    }

    // 参考  null==null 返回true
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointA = headA;
        ListNode pointB = headB;

        while (pointA != pointB) {
            pointA = (pointA == null ? headA : pointA.next);
            pointB = (pointB == null ? headB : pointB.next);
        }
        return pointA;
    }


    // 判断是否相交
    public static Boolean isIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headKey = headA;
        while (headKey != null) {
            if (headKey.next == null) {
                break;
            }
            headKey = headKey.next;
        }
        headKey = headB;
        while (headKey != null) {
            headKey = headKey.next;
            if (headA == headKey) {
                return true;
            }
        }
        return false;
    }


    // 链表反转、不能cur.next=cur,死链
    private static ListNode reverse(ListNode head) {
        ListNode headA = head;
        ListNode reveseHead = headA;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (headA != null) {
            nextNode = headA.next;
            if (nextNode == null) {
                reveseHead = headA;
            }
            headA.next = prevNode;
            prevNode = headA;
            headA = nextNode;
        }
        return reveseHead;

    }

}

// prev = cur;
//            if (firstHead == null) {
//                firstHead.next = prev;
//            }
//            prev.next = prev;
//            prev = prev.next;
//