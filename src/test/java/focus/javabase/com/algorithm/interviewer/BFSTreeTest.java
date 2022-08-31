package focus.javabase.com.algorithm.interviewer;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.VerifyUtils;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class BFSTreeTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);
        inputArray = new Integer[]{3, 9, 20, 15, 7};
        exceptedArrayList = Arrays.asList(inputArray);
    }

    @Test
    public void bfs() {
        VerifyUtils.verifyList(exceptedArrayList, BFSTree.bfs(inputTree));
    }
}