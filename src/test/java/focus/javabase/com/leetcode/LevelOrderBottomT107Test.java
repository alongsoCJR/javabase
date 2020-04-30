package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


//Given a binary tree, return the bottom-up level order traversal of its nodes'
//values. (ie, from left to right, level by level from leaf to root).
//
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
//return its bottom-up level order traversal as:
//
//[
//  [15,7],
//  [9,20],
//  [3]
//]
//
public class LevelOrderBottomT107Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);

        inputTwoArr = new int[][]{{15, 7}, {9, 20}, {3}};
    }

    @Test
    public void levelOrderBottom() {
        outputArrayList = LevelOrderBottomT107.levelOrderBottom(inputTree);
        System.out.println(outputArrayList);
//        LevelOrderBottomT107.printLevelOrderBottom(inputTree);
    }
}