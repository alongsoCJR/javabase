package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetKthFromEndO22Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(1);
        inputList.next.next = new ListNode(2);

        inputNum = 1;
    }

    @Test
    public void getKthFromEnd() {
        GetKthFromEndO22.getKthFromEnd(inputList, inputNum);
    }
}