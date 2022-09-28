package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseSegmentListNodeTest extends AbstractTest {

    @Before
    public void setUp() {
        inputList = new ListNode(1);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(3);
        inputList.next.next.next = new ListNode(4);
        inputList.next.next.next.next = new ListNode(5);


        exceptedList = new ListNode(3);
        exceptedList.next = new ListNode(2);
        exceptedList.next.next = new ListNode(1);
        exceptedList.next.next.next = new ListNode(4);
        exceptedList.next.next.next.next = new ListNode(5);
        inputNum = 3;
    }


    @Test
    public void reverseSegmentListNode() {
        outputList = ReverseListNode.reverseSegmentListNode1(inputList, inputNum);
        while (exceptedList != null) {
            Assert.assertEquals(exceptedList.val, outputList.val);
            exceptedList = exceptedList.next;
            outputList = outputList.next;
        }
    }
}