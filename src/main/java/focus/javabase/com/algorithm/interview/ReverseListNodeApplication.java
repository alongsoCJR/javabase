package focus.javabase.com.algorithm.interview;


/**
 * @Author alongso.cjr
 * @Description bd 链表的反转
 * @Date 2021-04-07 17:03
 **/
public class ReverseListNodeApplication {


    public static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }




}

class ListNode {
    ListNode(int val) {
        this.val = val;
    }

    int val;
    ListNode next;
}