package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrintLevelOrderO32Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(8);
        inputTree.left = new TreeNode(6);
        inputTree.right = new TreeNode(10);
        inputTree.left.left = new TreeNode(5);
        inputTree.left.right = new TreeNode(7);
        inputTree.right.left = new TreeNode(9);
        inputTree.right.right = new TreeNode(11);

    }

    @Test
    public void printLevelOrder() {
        PrintLevelOrderO32.printLevelOrder(inputTree);
    }

    @Test
    public void printLevelOrderDiffColumns() {
        List<List<Integer>> outPutList = PrintLevelOrderO32.printLevelOrderDiffColumns(inputTree);
        System.out.println(outPutList);
    }

    @Test
    public void printLevelOrderDiff() {
        List<List<Integer>> outPutList = PrintLevelOrderO32.printLevelOrderDiff(inputTree);
        System.out.println(outPutList);
    }
}