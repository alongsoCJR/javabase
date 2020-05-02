package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given an array where elements are sorted in ascending order, convert it to a h
//eight balanced BST.
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
//n which the depth of the two subtrees of every node never differ by more than 1.
//
//
// Example:
//
//
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following he
//ight balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索

// 答案还不是唯一的

public class SortedArrayToBSTT108Test extends AbstractTest {


    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{-10, -3, 0, 5, 9};

    }

    @Test
    public void sortedArrayToBST() {
        outputTree = SortedArrayToBSTT108.sortedArrayToBST(inputNums);
    }
}