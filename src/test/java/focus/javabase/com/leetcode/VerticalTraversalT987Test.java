package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerticalTraversalT987Test extends AbstractTest {


    @Before
    public void setUp() throws Exception {

        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.left.left = new TreeNode(4);
        inputTree.left.right = new TreeNode(5);
        inputTree.right = new TreeNode(3);
        inputTree.right.left = new TreeNode(6);
        inputTree.right.right = new TreeNode(7);
    }

    @Test
    public void verticalTraversal() {
        outputArrayList = VerticalTraversalT987.verticalTraversa0(inputTree);
    }
}