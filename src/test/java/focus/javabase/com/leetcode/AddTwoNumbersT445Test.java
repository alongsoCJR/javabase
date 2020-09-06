package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersT445Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        /**(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)**/
        inputList = new ListNode(7);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(4);
        inputList.next.next.next = new ListNode(3);

        /**[5,6,4]**/
        inputList2 = new ListNode(5);
        inputList2.next = new ListNode(6);
        inputList2.next.next = new ListNode(4);
    }

    // 7 -> 8 -> 0 -> 7
    @Test
    public void addTwoNumbers() {

        outputList = AddTwoNumbersT445.addTwoNumbers(inputList, inputList2);
    }


    @Before
    public void setUp0() throws Exception {
        inputList = new ListNode(5);
        inputList2 = new ListNode(5);
    }
    // 7 -> 8 -> 0 -> 7

    //info
    //			Wrong Answer:
    //			input:[5]
    //			[5]
    //			Output:[0]
    //			Expected:[1,0]
    //			stdout:
    //
    @Test
    public void addTwoNumbers0() {

        outputList = AddTwoNumbersT445.addTwoNumbers0(inputList, inputList2);
    }
}