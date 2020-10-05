package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.leetcode.base.ListNode;

import java.util.Stack;

/**
 * @Author chenjianrong-lhq
 * @Description 从尾到头打印链表
 * @Date 2020-10-05 10:26
 **/
public class ReversePrintNodeListO006 {

    // 改变了输入链表的结构
    public static void reversePrintNodeList(ListNode head) {
        // 反转链表
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode cur = node.next;
            node.next = prev;
            prev = node;
            node = cur;
        }

        // 打印
        while (prev != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }

    }

    // 栈实现
    public static void reversePrintNodeList0(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;

        // 放入栈
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        // 弹出栈
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // 递归实现
    public static void reversePrintNodeList1(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                reversePrintNodeList1(head.next);
            }
            System.out.println(head.val);
        }
    }
}