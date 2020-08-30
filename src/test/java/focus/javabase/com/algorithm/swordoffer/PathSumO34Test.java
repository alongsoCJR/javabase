package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathSumO34Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {

        inputTree = new TreeNode(5);
        inputTree.left = new TreeNode(4);
        inputTree.right = new TreeNode(8);
        inputTree.left.left = new TreeNode(11);
        inputTree.right.left = new TreeNode(13);
        inputTree.right.right = new TreeNode(4);
        inputTree.left.left.left = new TreeNode(7);
        inputTree.left.left.right = new TreeNode(2);
        inputTree.right.right.left = new TreeNode(5);
        inputTree.right.right.right = new TreeNode(1);

        inputNum = 22;
    }

    @Test
    public void pathSum() {
        outputArrayList = PathSumO34.pathSum(inputTree, inputNum);
        System.out.println(outputArrayList);
    }

    @Test
    public void pathSum0() {
        Assert.assertEquals(true, PathSumO34.pathSum0(inputTree, inputNum));
    }

    @Test
    public void pathSum1() {
        outputArrayList = PathSumO34.pathSum1(inputTree, inputNum);
        System.out.println(outputArrayList);
    }
}