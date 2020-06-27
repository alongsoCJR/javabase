package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Write a program to find the node at which the intersection of two singly linke
//d lists begins.
//
// For example, the following two linked lists:
//
//
// begin to intersect at node c1.
//
//
//
// Example 1:
//
//
//
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not
//be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. F
//rom the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the inter
//sected node in A; There are 3 nodes before the intersected node in B.
//
//
//
// Example 2:
//
//
//
//Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Reference of the node with value = 2
//Input Explanation: The intersected node's value is 2 (note that this must not
//be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. F
//rom the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
// node in A; There are 1 node before the intersected node in B.
//
//
//
//
// Example 3:
//
//
//
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: null
//Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B
//, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be
//0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
//
//
//
//
// Notes:
//
//
// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function retu
//rns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.
//
// Related Topics 链表

public class GetIntersectionNodeT160Test extends AbstractTest {

    //intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]


    @Before
    public void setUp() throws Exception {
        exceptedList = new ListNode(8);
        ListNode behand1 = new ListNode(4);
        ListNode behand2 = new ListNode(5);
        exceptedList.next = behand1;
        exceptedList.next.next = behand2;

        inputList = new ListNode(4);
        inputList.next = new ListNode(1);
        inputList.next.next = exceptedList;

        inputList2 = new ListNode(5);
        inputList2.next = new ListNode(0);
        inputList2.next.next = new ListNode(1);
        inputList2.next.next.next = exceptedList;

        exceptedBoolean = true;
    }


    //    @Before
    public void setUp1() throws Exception {

        inputList = new ListNode(2);
        inputList.next = new ListNode(6);
        inputList.next.next = new ListNode(4);

        inputList2 = new ListNode(1);
        inputList2.next = new ListNode(5);
        exceptedBoolean = false;
    }

    @Test
    public void getIntersectionNode() {
        outputList = GetIntersectionNodeT160.getIntersectionNode2(inputList, inputList2);
        Assert.assertEquals(exceptedList, outputList);
    }

    @Test
    public void getIntersectionNode1() {
        Assert.assertEquals(exceptedBoolean, GetIntersectionNodeT160.isIntersectionNode(inputList, inputList2));
    }
}