package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
public class IsSameTreeT100Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(3);

        outputTree = new TreeNode(1);
        outputTree.left = new TreeNode(2);
        outputTree.right = new TreeNode(3);

        exceptedBoolean = true;
    }


//    @Before
    public void setUp1() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);

        outputTree = new TreeNode(1);
        outputTree.right = new TreeNode(2);

        exceptedBoolean = false;
    }


    @Before
    public void setUp2() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(1);

        outputTree = new TreeNode(1);
        outputTree.left = new TreeNode(1);
        outputTree.right = new TreeNode(2);

        exceptedBoolean = false;
    }

    @Test
    public void isSameTree() {
        Assert.assertEquals(exceptedBoolean, IsSameTreeT100.isSameTree(inputTree, outputTree));
    }

    @Test
    public void printTree() {
        IsSameTreeT100.printTree(inputTree);
    }
}