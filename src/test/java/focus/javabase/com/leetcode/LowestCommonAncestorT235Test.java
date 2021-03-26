package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.ConvertUtils;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorT235Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTreeNums = new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        inputTree = ConvertUtils.convertTreeNode(inputTreeNums);
        exceptedTree = new TreeNode(6);
        inputTrees = new TreeNode[]{new TreeNode(2), new TreeNode(8)};
    }

    //    @Before
    public void setUp1() throws Exception {
        inputTreeNums = new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        inputTree = ConvertUtils.convertTreeNode(inputTreeNums);
        exceptedTree = new TreeNode(2);
        inputTrees = new TreeNode[]{new TreeNode(2), new TreeNode(4)};
    }

    @Test
    public void lowestCommonAncestor() {
        outputTree = LowestCommonAncestorT235.lowestCommonAncestor1(inputTree, inputTrees[0], inputTrees[1]);
        Assert.assertEquals(exceptedTree.val, outputTree.val);
    }
}