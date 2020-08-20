package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class BinaryTreePathsT257Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(4);
        inputTree.left.right = new TreeNode(5);

    }

    @Test
    public void binaryTreePaths() {
        List list = BinaryTreePathsT257.binaryTreePaths(inputTree);
        System.out.println(list);
    }

    @Test
    public void binaryTreePaths1() {
        List list = BinaryTreePathsT257.binaryTreePaths2(inputTree);
        System.out.println(list);
    }

    @Test
    public void binaryTreePaths2() {
        List list = BinaryTreePathsT257.binaryTreePaths4(inputTree);
        System.out.println(list);
    }
}