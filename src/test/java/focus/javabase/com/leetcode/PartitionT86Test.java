package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionT86Test extends AbstractTest {


    // Input: head = [1,4,3,2,5,2], x = 3
    // Output: [1,2,2,4,3,5]
    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(4);
        inputList.next.next = new ListNode(3);
        inputList.next.next.next = new ListNode(2);
        inputList.next.next.next.next = new ListNode(5);
        inputList.next.next.next.next.next = new ListNode(2);

        inputNum = 3;

    }

    @Test
    public void partition() {
        outputList = PartitionT86.partition(inputList, inputNum);
    }


    @Test
    public void partition2() {
        outputList = PartitionT86.partition2(inputList, inputNum);
    }
}