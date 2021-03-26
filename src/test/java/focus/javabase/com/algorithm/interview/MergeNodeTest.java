package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.ConvertUtils;
import focus.javabase.com.leetcode.MergeTwoListT021;
import focus.javabase.com.leetcode.base.ListNode;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeNodeTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputList = new ListNode(1);
        inputList.next = new ListNode(4);
        inputList.next.next = new ListNode(5);

        inputList2 = new ListNode(1);
        inputList2.next = new ListNode(3);
        inputList2.next.next = new ListNode(4);

        inputList3 = new ListNode(2);
        inputList3.next = new ListNode(6);

        inputNodeArrays = new ListNode[]{inputList, inputList2, inputList3};

        // 生成单向链表
        int[] excepeArr = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
        exceptedList = ConvertUtils.convertListNode(excepeArr);
    }

    @Test
    public void mergeNodeArray() {
        outputList = MergeNode.mergeNodeArray(inputNodeArrays);
        // 长度必须相等，不然抛空指针异常
        while (exceptedList != null || outputList != null) {
            Assert.assertEquals(exceptedList.val, outputList.val);
            exceptedList = exceptedList.next;
            outputList = outputList.next;
        }
    }
}