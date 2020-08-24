package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// 输入  二叉数 root
//  root
//              1
//            2    3
//          4   5
//
//  sub1
//            2
//          4   5

//  sub2
//            2
//          1
//        4

//  sub3
//            2
//          4
//        5


// 输出 true
public class IsSubTreeTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        // root
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(4);
        inputTree.left.right = new TreeNode(5);

        // subTree
        outputTree = new TreeNode(4);
//        outputTree.left = new TreeNode(4);
//        outputTree.right = new TreeNode(5);

    }


    //    @Before
    public void setUp1() throws Exception {
        // root
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(4);
        inputTree.left.right = new TreeNode(5);

        // subTree
        outputTree = new TreeNode(2);
        outputTree.left = new TreeNode(1);
        outputTree.left.left = new TreeNode(4);

    }

    //    @Before
    public void setUp2() throws Exception {
        // root
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(4);
        inputTree.left.right = new TreeNode(5);

        outputTree = new TreeNode(1);
        outputTree.left = new TreeNode(2);
        outputTree.right = new TreeNode(3);
    }

    @Test
    public void isSubTree1() {
        Assert.assertEquals(true, IsSubTree.isSubTree(inputTree, outputTree));
    }

    @Test
    public void isSubTree2() {
        Assert.assertEquals(false, IsSubTree.isSubTree(inputTree, outputTree));
    }

    @Test
    public void isSubTree3() {
        Assert.assertEquals(false, IsSubTree.isSubTree(inputTree, outputTree));
    }
}