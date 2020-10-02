package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class PathSumT113Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {

        inputTree = new TreeNode(5);
        inputTree.left = new TreeNode(4);
        inputTree.right = new TreeNode(8);
        inputTree.left.left = new TreeNode(11);
        inputTree.left.left.left = new TreeNode(7);
        inputTree.left.left.right = new TreeNode(2);
        inputTree.right.left = new TreeNode(13);
        inputTree.right.right = new TreeNode(4);
        inputTree.right.right.right = new TreeNode(1);

        inputNum = 22;
    }

    @Test
    public void pathSum() {

        outputArrayList = new PathSumT113().pathSum3(inputTree, inputNum);
    }
}