package focus.javabase.com.algorithm.swordoffer;

public class MinStack {

    ListNode head = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new ListNode(x, x);
        } else {
            ListNode node = new ListNode(x, Math.min(x, head.val));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head != null) {
            return head.val;
        }
        return 0;
    }

    public int min() {
        if (head != null) {
            return head.min;
        }
        return 0;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, 2);
        ListNode node = new ListNode(-1, -2);
        node.next = head;
        head = node;
    }
}

class ListNode {
    public int val;
    public int min;
    public ListNode next;

    public ListNode(int x, int min) {
        val = x;
        this.min = min;
    }
}

