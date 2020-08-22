package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class MirrorTreeNodeO027Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(4);
        inputTree.left.right = new TreeNode(5);
        inputTree.right.left = new TreeNode(6);
        inputTree.right.right = new TreeNode(7);
    }

    @Test
    public void mirrorByRecursion() {
        outputTree = MirrorTreeNodeO027.mirrorByRecursion(inputTree);
        System.out.println(outputTree);
    }

    @Test
    public void mirrorByIteration() {
        outputTree = MirrorTreeNodeO027.mirrorByIteration(inputTree);
    }
}