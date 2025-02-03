package focus.javabase.com.algorithm.interview2;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxPathSumTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {

        inputTree = new TreeNode(5);
        inputTree.left = new TreeNode(4);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(2);
        inputTree.left.right = new TreeNode(1);
        inputTree.right.left = new TreeNode(6);
        inputTree.right.right = new TreeNode(-7);
        exceptedNum = 14;
    }

    @Test
    public void maxPathSum() {
        Assert.assertEquals(exceptedNum, MaxPathSum.maxPathSum(inputTree));
    }
}