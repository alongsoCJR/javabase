package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NodeList;

import static focus.javabase.com.leetcode.MergeTwoListT021Test.l2;


//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
public class DeleteDuplicatesT083Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(1);
        inputList.next.next = new ListNode(2);
        inputList.next.next.next = new ListNode(3);
        inputList.next.next.next.next = new ListNode(3);

        exceptedList = new ListNode(1);
        exceptedList.next = new ListNode(2);
        exceptedList.next.next = new ListNode(3);
    }

    @Test
    public void deleteDuplicates() {
        outputList = DeleteDuplicatesT083.deleteDuplicates(inputList);
        while (exceptedList != null) {
            Assert.assertEquals(exceptedList.val, outputList.val);
            exceptedList = exceptedList.next;
            outputList = outputList.next;
        }

    }
}