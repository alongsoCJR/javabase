package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its minimum depth = 2.
// Related Topics 树 深度优先搜索 广度优先搜索


public class MinDepthT111Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);
        exceptedNum = 2;
    }


//    @Before
    public void setUp1() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);

        exceptedNum = 2;
    }


    @Before
    public void setUp2() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.left.left = new TreeNode(3);
        inputTree.left.left.left = new TreeNode(4);
        inputTree.left.left.left.left = new TreeNode(5);

        exceptedNum = 5;
    }

    //info
    //			Wrong Answer:
    //			input:[1,2]
    //			Output:1
    //			Expected:2
    //			stdout:



    //info
    //			Wrong Answer:
    //			input:[1,2,null,3,null,4,null,5]
    //			Output:2
    //			Expected:5
    //			stdout:
    @Test
    public void maxDepth() {
        outputNum = MinDepthT111.minDepth(inputTree);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}