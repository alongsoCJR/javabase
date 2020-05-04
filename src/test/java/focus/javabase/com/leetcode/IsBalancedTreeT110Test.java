package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as:
//
//
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1.
//
//
//
//
// Example 1:
//
// Given the following tree [3,9,20,null,null,15,7]:
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// Return true.
//
//Example 2:
//
// Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// Return false.
// Related Topics 树 深度优先搜索

public class IsBalancedTreeT110Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {

        inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);
        exceptedBoolean = true;
    }


    @Before
    public void setUp1() throws Exception {

        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(2);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);
        exceptedBoolean = true;
    }

    @Test
    public void isBalanced() {
//        System.out.println(IsBalancedTreeT110.minDepth(inputTree));
        Assert.assertEquals(exceptedBoolean, IsBalancedTreeT110.isBalanced0(inputTree));
    }

    //	info
    //			Wrong Answer:
    //			input:[1,2,2,3,null,null,3,4,null,null,4]
    //			Output:true
    //			Expected:false
    //			stdout:

    //info
    //			Wrong Answer:
    //			input:[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
    //			Output:false
    //			Expected:true
    //			stdout:
    @Test
    public void isBalanced0() {
//        System.out.println(IsBalancedTreeT110.minDepth(inputTree));
        Assert.assertEquals(exceptedBoolean, IsBalancedTreeT110.isBalanced(inputTree));
    }
}