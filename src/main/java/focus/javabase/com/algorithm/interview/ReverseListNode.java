package focus.javabase.com.algorithm.interview;

import focus.javabase.com.leetcode.base.ListNode;

/**
 * @Author Jianrong.Chen
 * @Description zj 机试 分段链表反转
 * @Date 2022-09-21 11:08
 */
public class ReverseListNode {

    public static ListNode reverseSegmentListNode(ListNode head, int k) {
        // 遍历一遍，分段
        int index = 0;
        ListNode indexRoot = head;
        while (indexRoot != null) {
            indexRoot = indexRoot.next;
            index++;
        }

        // 计算分段的次数
        int segment = index / k;
        // 使用前置节点记录
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;

        ListNode startNode = head;
        ListNode nextStartNode = head;
        for (int i = 0; i < segment; i++) {
            // 记录下一个起点
            for (int j = 0; j < k; j++) {
                nextStartNode = nextStartNode.next;
            }
            // 将分段的拼接在前置节点尾部
            cur.next = reverseListNodeByTheta(startNode, k);
            // 走到分段末尾的节点
            for (int j = 0; j < k; j++) {
                cur = cur.next;
            }
            startNode = nextStartNode;
        }

        // 如果nextStartNode不为空，则拼接尾部
        if (nextStartNode != null) {
            cur.next = nextStartNode;
        }

        // 返回前置节点的next节点
        return preHead.next;
    }

    public static ListNode reverseListNodeByTheta(ListNode root, int theta) {
        ListNode prev = null;
        int reverseCount = 0;
        ListNode node = root;
        while (node != null && reverseCount < theta) {
            ListNode cur = node.next;
            node.next = prev;
            prev = node;
            node = cur;
            reverseCount++;
        }
        return prev;
    }


    public static ListNode reverseSegmentListNode1(ListNode head, int k) {
        // 使用前置节点记录
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode end = preHead;
        while (end != null) {
            for (int i = 0; i < k & end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            ListNode start = pre.next;
            ListNode next = end.next;
//            end.next = null;
            pre.next = reverseListNodeByTheta(start, k);

            // 处理空的情况
            start.next = next;
            pre = start;
            end = pre;
        }

        // 返回前置节点的next节点
        return preHead.next;
    }


    //if (index % k == 0) {
    //                start = end;
    //                cur.next = reverseListNodeByTheta(start, k);
    //            } else {
    //                cur = cur.next;
    //                end = end.next;
    //            }
}

