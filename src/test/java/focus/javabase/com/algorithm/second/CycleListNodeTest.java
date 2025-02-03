package focus.javabase.com.algorithm.second;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CycleListNodeTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {

        inputList = new ListNode(3);

        ListNode detectNode = new ListNode(2);
        inputList.next = detectNode;
        inputList.next.next = new ListNode(0);
        inputList.next.next.next = new ListNode(-4);
        inputList.next.next.next.next = detectNode;
        exceptedBoolean = true;

    }


    // Your input:[3,2,0,-4]
    //			1
    @Test
    public void detectCycle() {
        outputList = CycleListNode.detectCycle(inputList);
    }

    @Test
    public void isCycle() {
        assertEquals(exceptedBoolean, CycleListNode.isCycle(inputList));
    }

    @Test
    public void detectCycle01() {
        outputList = CycleListNode.detectCycle01(inputList);
    }
}