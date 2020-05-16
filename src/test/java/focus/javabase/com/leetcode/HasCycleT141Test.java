package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given a linked list, determine if it has a cycle in it.
//
// To represent a cycle in the given linked list, we use an integer pos which re
//presents the position (0-indexed) in the linked list where tail connects to. If
//pos is -1, then there is no cycle in the linked list.
//
//
//
//
// Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
//
//
//
//
//
//
// Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
//
//
//
//
//
//
// Example 3:
//
//
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
//
//
//
//
//
//
//
// Follow up:
//
// Can you solve it using O(1) (i.e. constant) memory?
// Related Topics 链表 双指针

public class HasCycleT141Test extends AbstractTest {

    //head = [3,2,0,-4], pos = 1
    @Before
    public void setUp() throws Exception {
        ListNode posNode = new ListNode(2);
        inputList = new ListNode(3);
        inputList.next = posNode;
        inputList.next.next = new ListNode(0);
        inputList.next.next.next = new ListNode(4);
        inputList.next.next.next.next = posNode;

        exceptedBoolean = true;
    }

    @Test
    public void hasCycle() {
        Assert.assertEquals(exceptedBoolean, HasCycleT141.hasCycle(inputList));
    }
}