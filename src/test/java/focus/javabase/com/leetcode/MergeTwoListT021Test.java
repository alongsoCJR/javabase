package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoListT021Test extends AbstractTest {

    public static MergeTwoListT021.ListNode l1 = null;
    public static MergeTwoListT021.ListNode l2 = null;
    public static MergeTwoListT021.ListNode exceptListNode = null;

    public static int[] excepetArr = null;


    // 输入：1->2->4, 1->3->4
//    输出：1->1->2->3->4->4
    @Before
    public void setUp() throws Exception {
        l1 = new MergeTwoListT021.ListNode(1);
        l1.next = new MergeTwoListT021.ListNode(2);
        l1.next.next = new MergeTwoListT021.ListNode(4);

        l2 = new MergeTwoListT021.ListNode(1);
        l2.next = new MergeTwoListT021.ListNode(3);
        l2.next.next = new MergeTwoListT021.ListNode(4);

        int[] excepeArr = new int[]{1, 1, 2, 3, 4, 4};
        // 如何生成单向链表
        MergeTwoListT021.ListNode first = new MergeTwoListT021.ListNode(excepeArr[0]);
        exceptListNode = first;
        for (int i = 1; i < excepeArr.length; i++) {
            MergeTwoListT021.ListNode node = new MergeTwoListT021.ListNode(excepeArr[i]);
            first.next = node;
            first = node;
        }
    }


//    @Before
//    public void setUp() throws Exception {
//        l1 = new MergeTwoListT021.ListNodeBak(2);
//
//        l2 = new MergeTwoListT021.ListNodeBak(1);
//
//        int[] excepeArr = new int[]{1, 2};
//        // 如何生成单向链表
//        MergeTwoListT021.ListNodeBak first = null;
//        for (int i = 0; i < excepeArr.length; i++) {
//            first = new MergeTwoListT021.ListNodeBak(excepeArr[i]);
//            if (exceptListNode == null) {
//                exceptListNode = first;
//            }
//            first = first.next;
//        }
//    }


//    @Before
//    public void setUp() throws Exception {
//        l1 = new MergeTwoListT021.ListNodeBak(-9);
//        l1.next = new MergeTwoListT021.ListNodeBak(3);
//
//        l2 = new MergeTwoListT021.ListNodeBak(5);
//        l2.next = new MergeTwoListT021.ListNodeBak(7);
//
//        excepetArr = new int[]{-9, 3, 5, 7};
//
//    }

    @Test
    public void mergeTwoLists() {
        MergeTwoListT021.ListNode actual = MergeTwoListT021.mergeTwoLists(l1, l2);
        while (exceptListNode != null) {
            Assert.assertEquals(exceptListNode.val, actual.val);
            exceptListNode = exceptListNode.next;
            // follow you
            actual = actual.next;
        }
    }

    // [1][2]   [2][1]
    @Test
    public void mergeTwoLists1() {
        MergeTwoListT021.ListNode actual = MergeTwoListT021.mergeTwoLists(l1, l2);
        while (exceptListNode != null) {
            Assert.assertEquals(exceptListNode.val, (actual == null ? Long.MAX_VALUE : actual.val));
            exceptListNode = exceptListNode.next;
        }
    }

    @Test
    public void mergeTwoLists2() {
        MergeTwoListT021.ListNode actual = MergeTwoListT021.mergeTwoLists(l1, l2);
        for (int i = 0; i < excepetArr.length; i++) {
            int val = actual == null ? (int) Long.MAX_VALUE : actual.val;
            Assert.assertEquals(excepetArr[i], val);
            actual = actual.next;
        }
    }


//    @Before
//    public void setUp() throws Exception {
//        l1 = new MergeTwoListT021.ListNodeBak(-10);
//        l1.next = new MergeTwoListT021.ListNodeBak(-10);
//        l1.next.next = new MergeTwoListT021.ListNodeBak(-9);
//        l1.next.next.next = new MergeTwoListT021.ListNodeBak(-4);
//        l1.next.next.next.next = new MergeTwoListT021.ListNodeBak(1);
//        l1.next.next.next.next.next = new MergeTwoListT021.ListNodeBak(6);
//        l1.next.next.next.next.next.next = new MergeTwoListT021.ListNodeBak(6);
//
//        l2 = new MergeTwoListT021.ListNodeBak(-7);
//
//        excepetArr = new int[]{-10, -10, -9, -7, -4, 1, 6, 6};
//    }

    /**
     * Wrong Answer:
     * input:[-10,-10,-9,-4,1,6,6]
     * [-7]
     * Output:[-10,-10,-10,-9,-4,1,6,6]
     * Expected:[-10,-10,-9,-7,-4,1,6,6]
     **/
    @Test
    public void mergeTwoLists3() {
        MergeTwoListT021.ListNode actual = MergeTwoListT021.mergeTwoLists(l1, l2);
        for (int i = 0; i < excepetArr.length; i++) {
            int val = actual == null ? (int) Long.MAX_VALUE : actual.val;
            Assert.assertEquals(excepetArr[i], val);
            actual = actual.next;
        }
    }

    //  输入：1->2->4, 1->3->4
    //  输出：1->1->2->3->4->4
    @Test
    public void mergeTwoList2() {
        MergeTwoListT021.ListNode actual = MergeTwoListT021.mergeTwoLists2(l1, l2);
        for (int i = 0; i < excepetArr.length; i++) {
            int val = actual == null ? (int) Long.MAX_VALUE : actual.val;
            Assert.assertEquals(excepetArr[i], val);
            actual = actual.next;
        }
    }


    @Test
    public void mergeTwoList3() {
        MergeTwoListT021.ListNode actual = MergeTwoListT021.mergeTwoLists3(l1, l2);
        for (int i = 0; i < excepetArr.length; i++) {
            int val = actual == null ? (int) Long.MAX_VALUE : actual.val;
            Assert.assertEquals(excepetArr[i], val);
            actual = actual.next;
        }
    }
}