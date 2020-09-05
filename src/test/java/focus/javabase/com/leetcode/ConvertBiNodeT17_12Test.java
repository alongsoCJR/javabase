package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertBiNodeT17_12Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(2);
        inputTree.left = new TreeNode(1);
        inputTree.right = new TreeNode(3);
    }

    //    @Before
    public void setUp0() throws Exception {
        inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(9);
        inputTree.right = new TreeNode(20);
        inputTree.right.left = new TreeNode(15);
        inputTree.right.right = new TreeNode(7);
    }

    @Test
    public void convertBiNode() {
        outputTree = ConvertBiNodeT17_12.convertBiNode(inputTree);
    }
}