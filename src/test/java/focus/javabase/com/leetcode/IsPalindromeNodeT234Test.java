package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given a singly linked list, determine if it is a palindrome.
//
// Example 1:
//
//
//Input: 1->2
//Output: false
//
// Example 2:
//
//
//Input: 1->2->2->1
//Output: true
//
// Follow up:
//Could you do it in O(n) time and O(1) space?
// Related Topics 链表 双指针


public class IsPalindromeNodeT234Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(1);
//        inputList.next.next.next = new ListNode(1);

        exceptedBoolean = true;
    }

    //info
    //			Wrong Answer:
    //			input:[1]
    //			Output:false
    //			Expected:true
    //			stdout:
    //Runtime:8 ms, faster than 6.86% of Java online submissions.
    //Memory Usage:46.4 MB, less than 5.41% of Java online submissions
    @Test
    public void isPalindrome() {
        Assert.assertEquals(exceptedBoolean, IsPalindromeNodeT234.isPalindrome1(inputList));
    }
}