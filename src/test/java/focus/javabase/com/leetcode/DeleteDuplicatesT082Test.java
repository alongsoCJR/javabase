package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

public class DeleteDuplicatesT082Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(2);
        inputList.next.next.next = new ListNode(3);
        inputList.next.next.next.next = new ListNode(3);
        inputList.next.next.next.next.next = new ListNode(4);
        inputList.next.next.next.next.next.next = new ListNode(4);
        inputList.next.next.next.next.next.next.next = new ListNode(5);

    }

    @Test
    public void testDeleteDuplicates() {
        outputList = DeleteDuplicatesT082.deleteDuplicates(inputList);
    }
}