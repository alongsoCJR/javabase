package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given head which is a reference node to a singly-linked list. The value of eac
//h node in the linked list is either 0 or 1. The linked list holds the binary rep
//resentation of a number.
//
// Return the decimal value of the number in the linked list.
//
//
// Example 1:
//
//
//Input: head = [1,0,1]
//Output: 5
//Explanation: (101) in base 2 = (5) in base 10
//
//
// Example 2:
//
//
//Input: head = [0]
//Output: 0
//
//
// Example 3:
//
//
//Input: head = [1]
//Output: 1
//
//
// Example 4:
//
//
//Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//Output: 18880
//
//
// Example 5:
//
//
//Input: head = [0,0]
//Output: 0
//
//
//
// Constraints:
//
//
// The Linked List is not empty.
// Number of nodes will not exceed 30.
// Each node's value is either 0 or 1.
// Related Topics 位运算 链表


public class GetDecimalValueT1290Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(0);
        inputList.next.next = new ListNode(1);

        exceptedNum = 5;
    }

    @Test
    public void getDecimalValue() {
        Assert.assertEquals(exceptedNum, GetDecimalValueT1290.getDecimalValue1(inputList));
    }
}