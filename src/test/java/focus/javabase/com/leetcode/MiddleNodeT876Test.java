package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a non-empty, singly linked list with head node head, return a middle nod
//e of linked list.
//
// If there are two middle nodes, return the second middle node.
//
//
//
//
// Example 1:
//
//
//Input: [1,2,3,4,5]
//Output: Node 3 from this list (Serialization: [3,4,5])
//The returned node has value 3.  (The judge's serialization of this node is [3,
//4,5]).
//Note that we returned a ListNode object ans, such that:
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next =
// NULL.
//
//
//
// Example 2:
//
//
//Input: [1,2,3,4,5,6]
//Output: Node 4 from this list (Serialization: [4,5,6])
//Since the list has two middle nodes with values 3 and 4, we return the second
//one.
//
//
//
//
// Note:
//
//
// The number of nodes in the given list will be between 1 and 100.
//
//
//
// Related Topics 链表

public class MiddleNodeT876Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        exceptedList = new ListNode(1);

        inputList = new ListNode(4);
        inputList.next = new ListNode(5);
        inputList.next.next = exceptedList;
        inputList.next.next.next = new ListNode(9);
        inputList.next.next.next.next = new ListNode(9);
    }

    @Test
    public void middleNode() {
        Assert.assertEquals(exceptedList, MiddleNodeT876.middleNode(inputList));
    }
}