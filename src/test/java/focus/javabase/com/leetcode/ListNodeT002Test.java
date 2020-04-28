package focus.javabase.com.leetcode;

import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNodeT002Test {

    List<Integer> targetList = new ArrayList<>();

    /**
     * 还没有考虑两链表长度不等的情况与进位的情况
     **/
    @Test
    public void addTwoNumbers() {
        /**[2,4,3]**/
        ListNode ListNode1 = new ListNode(2);
        ListNode1.next = new ListNode(4);
        ListNode1.next.next = new ListNode(3);

        /**[5,6,4]**/
        ListNode ListNode2 = new ListNode(5);
        ListNode2.next = new ListNode(6);
        ListNode2.next.next = new ListNode(4);

        ListNode resultListNode = ListNodeT002.addTwoNumbersContinueCarryBit(ListNode1, ListNode2);
        while (resultListNode != null) {
            /**except output [7,0,8]**/
            targetList.add(resultListNode.val);
            resultListNode = resultListNode.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{7, 0, 8}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    /**
     * 考虑末尾进位的情况
     **/
    @Test
    public void addTwoNumbers1() {
        /**[5]**/
        ListNode ListNode1 = new ListNode(5);

        /**[5]**/
        ListNode ListNode2 = new ListNode(5);

        ListNode resultListNode = ListNodeT002.addTwoNumbersContinueCarryBit(ListNode1, ListNode2);
        while (resultListNode != null) {
            /**except output [0,1]**/
            targetList.add(resultListNode.val);
            resultListNode = resultListNode.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{0, 1}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    /**
     * 两链表长度不等
     **/
    @Test
    public void addTwoNumbers2() {
        /**[3，5]**/
        ListNode ListNode1 = new ListNode(3);
        ListNode1.next = new ListNode(5);

        /**[5]**/
        ListNode ListNode2 = new ListNode(5);

        ListNode resultListNode = ListNodeT002.addTwoNumbersContinueCarryBit(ListNode1, ListNode2);
        while (resultListNode != null) {
            /**except output [0,4]**/
            targetList.add(resultListNode.val);
            resultListNode = resultListNode.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{8, 5}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }


    /**
     * 两链表长度不等,最高位需要连续两次进位
     **/
    @Test
    public void addTwoNumbers3() {
        /**[9,9]**/
        ListNode ListNode1 = new ListNode(9);
        ListNode1.next = new ListNode(9);

        /**[1]**/
        ListNode ListNode2 = new ListNode(1);

        ListNode resultListNode = ListNodeT002.addTwoNumbersContinueCarryBit(ListNode1, ListNode2);
        while (resultListNode != null) {
            /**except output [0,0,1]**/
            targetList.add(resultListNode.val);
            resultListNode = resultListNode.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{0, 0, 1}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }


    /**
     * 两链表长度不等,最高位需要连续三次进位
     **/
    @Test
    public void addTwoNumbers4() {
        /**[8,9,9]**/
        ListNode ListNode1 = new ListNode(8);
        ListNode1.next = new ListNode(9);
        ListNode1.next.next = new ListNode(9);

        /**[1]**/
        ListNode ListNode2 = new ListNode(2);

        ListNode resultListNode = ListNodeT002.addTwoNumbersContinueCarryBit(ListNode1, ListNode2);
        while (resultListNode != null) {
            /**except output [0,0,0,1]**/
            targetList.add(resultListNode.val);
            resultListNode = resultListNode.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{0, 0, 0, 1}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    /**
     * 考虑传入为空列表时
     **/
    @Test
    public void addTwoNumbers5() {
        /**[8,9,9]**/
        ListNode ListNode1 = new ListNode(8);
        ListNode1.next = new ListNode(9);
        ListNode1.next.next = new ListNode(9);


        ListNode resultListNode = ListNodeT002.addTwoNumbersContinueCarryBit(ListNode1, null);
        while (resultListNode != null) {
            /**except output [8，9,9]**/
            targetList.add(resultListNode.val);
            resultListNode = resultListNode.next;
        }

        if (!varifyListOrder(targetList, Arrays.asList(new Integer[]{8, 9, 9}))) {
            Assert.fail("与期望的输出值对不上！");
        }
    }

    private boolean varifyListOrder(List<Integer> targetList, List<Integer> exceptList) {
        if (targetList == null && exceptList == null) {
            return true;
        }
        if (targetList != null && exceptList != null &&
                targetList.size() == exceptList.size()) {
            for (int i = 0; i < exceptList.size(); i++) {
                if (exceptList.get(i) != targetList.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}