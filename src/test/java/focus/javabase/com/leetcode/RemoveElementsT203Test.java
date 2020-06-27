package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementsT203Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(1);
        inputList.next.next = new ListNode(2);

        inputNum = 1;
    }

    @Before
    public void setUp1() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(6);
        inputList.next.next.next = new ListNode(3);
        inputList.next.next.next.next = new ListNode(4);
        inputList.next.next.next.next.next = new ListNode(5);
        inputList.next.next.next.next.next.next = new ListNode(6);
        inputList.next.next.next.next.next.next.next = new ListNode(6);
        inputList.next.next.next.next.next.next.next.next = new ListNode(6);

        inputNum = 6;
    }

    // [1,2,6,3,4,5,6]
    // 6
    @Test
    public void removeElements() {
        RemoveElementsT203.removeElements(inputList, inputNum);
    }
}