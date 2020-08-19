package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.BinaryTreePathsT257;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


// 输入
//
// 二叉数         1
//            2    3
//          4   5


// 输出 [
//          [1,2,4],
//          [1,2,5],
//          [1,3]
//     ]
public class PrintTreePathsTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(3);
        inputTree.left.left = new TreeNode(4);
        inputTree.left.right = new TreeNode(5);

    }

    @Test
    public void print() {
        List list = PrintTreePaths.print1(inputTree);
        System.out.println(list);
    }
}