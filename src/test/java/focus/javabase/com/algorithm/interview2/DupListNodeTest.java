package focus.javabase.com.algorithm.interview2;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DupListNodeTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(3);
        inputList.next.next.next = new ListNode(3);
        inputList.next.next.next.next = new ListNode(4);
        inputList.next.next.next.next.next = new ListNode(4);
        inputList.next.next.next.next.next.next = new ListNode(4);
        inputList.next.next.next.next.next.next.next = new ListNode(5);


        exceptedList = new ListNode(1);
        exceptedList.next = new ListNode(2);
        exceptedList.next.next = new ListNode(3);
        exceptedList.next.next.next = new ListNode(4);
        exceptedList.next.next.next.next = new ListNode(5);
    }

    @Test
    public void deleteDuplicates() {
        outputList = DupListNode.deleteDuplicates(inputList);
        while (exceptedList != null) {
            Assert.assertEquals(exceptedList.val, outputList.val);
            exceptedList = exceptedList.next;
            outputList = outputList.next;
        }
    }
}