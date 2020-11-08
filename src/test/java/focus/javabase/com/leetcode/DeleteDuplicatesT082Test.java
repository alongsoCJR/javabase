package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

public class DeleteDuplicatesT082Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(1);
        inputList.next.next = new ListNode(2);
        inputList.next.next.next = new ListNode(2);
//        inputList.next.next.next.next = new ListNode(3);
//        inputList.next.next.next.next.next = new ListNode(4);
//        inputList.next.next.next.next.next.next = new ListNode(4);
//        inputList.next.next.next.next.next.next.next = new ListNode(5);

    }

//    @Before
    public void setUp0() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(1);
        inputList.next.next = new ListNode(1);
        inputList.next.next.next = new ListNode(2);
        inputList.next.next.next.next = new ListNode(3);
    }

    // info
    //					Compile Error:
    //					java.lang.NullPointerException
    //					at line 33, Solution.deleteDuplicates
    //					at line 57, __DriverSolution__.__helper__
    //					at line 85, __Driver__.main
    //					Your input:[1,1,1,2,3]
    //					stdout:


    // info
    //					Wrong Answer:
    //					input:[1,2,2]
    //					Output:[1,2,2]
    //					Expected:[1]
    //					stdout:


    // info
    //					Wrong Answer:
    //					input:[1,1,2,2]
    //					Output:[2]
    //					Expected:[]
    //					stdout:
    @Test
    public void testDeleteDuplicates() {
        outputList = DeleteDuplicatesT082.deleteDuplicates0(inputList);
    }


    @Test
    public void testDeleteDuplicates1() {
        outputList = DeleteDuplicatesT082.deleteDuplicates1(inputList);
    }
}