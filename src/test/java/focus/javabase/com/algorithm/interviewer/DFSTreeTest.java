package focus.javabase.com.algorithm.interviewer;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.VerifyUtils;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class DFSTreeTest extends AbstractTest {

//    @Before
    public void setUp0() throws Exception {
        inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);
        inputArray = new Integer[]{3, 9, 20, 15, 7};
        exceptedArrayList = Arrays.asList(inputArray);
    }


    @Before
    public void setUp1() throws Exception {
        inputTree = new TreeNode(5);
        inputTree.left = new TreeNode(4);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(2);
        inputTree.left.right = new TreeNode(1);
        inputTree.right.left = new TreeNode(6);
        inputTree.right.right = new TreeNode(7);
        inputArray = new Integer[]{5, 4, 2, 1, 3, 6, 7};
        exceptedArrayList = Arrays.asList(inputArray);
    }

    //    @Test
    public void dfsPrint() {
        DFSTree.dfsPrint(inputTree);
    }

    @Test
    public void dfs0() {
        VerifyUtils.verifyList(exceptedArrayList, DFSTree.dfs0(inputTree));
    }

    @Test
    public void dfs1() {
        VerifyUtils.verifyList(exceptedArrayList, DFSTree.dfs1(inputTree));
    }
}