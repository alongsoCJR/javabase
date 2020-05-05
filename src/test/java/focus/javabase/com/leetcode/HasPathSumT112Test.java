package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path s
//uch that adding up all the values along the path equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
//
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
//
// Related Topics 树 深度优先搜索


public class HasPathSumT112Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(5);
        inputTree.left = new TreeNode(4);
        inputTree.right = new TreeNode(8);
        inputTree.left.left = new TreeNode(11);
        inputTree.left.left.left = new TreeNode(7);
        inputTree.left.left.right = new TreeNode(2);
        inputTree.right.left = new TreeNode(13);
        inputTree.right.right = new TreeNode(4);
        inputTree.right.right.right = new TreeNode(1);

        inputNum = 22;
        exceptedBoolean = true;
    }


    //    @Before
    public void setUp1() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);

        inputNum = 1;
        exceptedBoolean = false;
    }

    //info
    //			Finished:
    //			Your input:[]
    //			0
    //			Output:false
    //			Expected:false
    //			stdout:

    //info
    //			Wrong Answer:
    //			input:[1,2]
    //			1
    //			Output:true
    //			Expected:false
    //			stdout:
    @Test
    public void hasPathSum() {
        Assert.assertEquals(exceptedBoolean, HasPathSumT112.hasPathSum(inputTree, inputNum));
    }
}