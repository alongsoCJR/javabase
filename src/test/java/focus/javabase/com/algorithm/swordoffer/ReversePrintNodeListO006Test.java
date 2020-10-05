package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePrintNodeListO006Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(2);
        inputList.next = new ListNode(3);
        inputList.next.next = new ListNode(4);
    }

    @Test
    public void reversePrintNodeList() {
        ReversePrintNodeListO006.reversePrintNodeList1(inputList);
    }
}