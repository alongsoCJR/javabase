package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetMaxTreeBranchTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(8);
        inputTree.left = new TreeNode(3);
        inputTree.right = new TreeNode(10);
        inputTree.left.left = new TreeNode(1);
        inputTree.left.right = new TreeNode(6);
        inputTree.left.right.left = new TreeNode(4);
        inputTree.left.right.right = new TreeNode(7);
        inputTree.right.right = new TreeNode(14);
        inputTree.right.right.left = new TreeNode(13);
    }

    @Test
    public void getMaxBranch() {
        System.out.println(GetMaxTreeBranch.getBBranchByIteration(inputTree));
    }
}