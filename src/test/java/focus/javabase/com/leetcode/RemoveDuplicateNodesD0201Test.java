package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicateNodesD0201Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(1);
        inputList.next.next = new ListNode(2);

    }

    @Test
    public void removeDuplicateNodes() {
        RemoveDuplicateNodesD02_01.removeDuplicateNodes(inputList);
    }
}