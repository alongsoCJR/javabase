package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics 链表

public class ReverseListT206Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(3);
        inputList.next.next.next = new ListNode(4);
        inputList.next.next.next.next = new ListNode(5);


        exceptedList = new ListNode(5);
        exceptedList.next = new ListNode(4);
        exceptedList.next.next = new ListNode(3);
        exceptedList.next.next.next = new ListNode(2);
        exceptedList.next.next.next.next = new ListNode(1);

    }

    @Test
    public void reverseList() {
        outputList = ReverseListT206.recursivelyReverseList(inputList);
        while (exceptedList != null) {
            Assert.assertEquals(exceptedList.val, outputList.val);
            exceptedList = exceptedList.next;
            outputList = outputList.next;
        }
    }
}