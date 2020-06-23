package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//Write a function to delete a node (except the tail) in a singly linked list, g
//iven only access to that node.
//
// Given linked list -- head = [4,5,1,9], which looks like following:
//
//
//
//
//
// Example 1:
//
//
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list shoul
//d become 4 -> 1 -> 9 after calling your function.
//
//
// Example 2:
//
//
//Input: head = [4,5,1,9], node = 1
//Output: [4,5,9]
//Explanation: You are given the third node with value 1, the linked list should
// become 4 -> 5 -> 9 after calling your function.
//
//
//
//
// Note:
//
//
// The linked list will have at least two elements.
// All of the nodes' values will be unique.
// The given node will not be the tail and it will always be a valid node of the
// linked list.
// Do not return anything from your function.
//
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

public class DeleteNodeT237Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        outputList = new ListNode(1);

        inputList = new ListNode(4);
        inputList.next = new ListNode(5);
        inputList.next.next = outputList;
        inputList.next.next.next = new ListNode(9);

    }

    @Test
    public void deleteNode() {
        DeleteNodeT237.deleteNode(inputList, outputList);
    }


    @Test
    public void deleteNode1() {
        DeleteNodeT237.deleteNode1(outputList);
    }
}