package focus.javabase.com.algorithm.interviewer;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.ReverseListT206;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseListNodeTest extends AbstractTest {

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
        outputList = ReverseListNode.reverse1(inputList);
        while (exceptedList != null) {
            Assert.assertEquals(exceptedList.val, outputList.val);
            exceptedList = exceptedList.next;
            outputList = outputList.next;
        }
    }
}