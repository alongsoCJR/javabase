package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node.
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
// return its depth = 3.
// Related Topics 树 深度优先搜索

public class MaxDepthT104Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);
        exceptedNum = 3;
    }

    @Test
    public void maxDepth() {
        outputNum = MaxDepthT104.maxDepth(inputTree);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}