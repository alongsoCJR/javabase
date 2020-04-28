package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索


// 深度优先搜索=先序遍历    广度优先搜索
public class IsSymmetricT101Test extends AbstractTest {

        @Before
    public void setUp() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.left.left = new TreeNode(3);
        inputTree.left.right = new TreeNode(4);
        inputTree.right = new TreeNode(2);
        inputTree.right.left = new TreeNode(4);
        inputTree.right.right = new TreeNode(3);


        exceptedBoolean = true;
    }

//        @Before
    public void setUp1() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.left.right = new TreeNode(3);
        inputTree.right = new TreeNode(2);
        inputTree.right.right = new TreeNode(3);


        exceptedBoolean = false;
    }

    //info
    //			Wrong Answer:
    //			input:[1,2,2,2,null,2]
    //			Output:true
    //			Expected:false
    //			stdout:
//    1
//   / \
//  2   2
// /   /
//2   2

//    @Before
    public void setUp2() throws Exception {
        inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(2);
        inputTree.right = new TreeNode(2);
        inputTree.left.left = new TreeNode(2);
        inputTree.right.left = new TreeNode(2);


        exceptedBoolean = false;
    }

    //info
    //			Wrong Answer:
    //			input:[2,3,3,4,5,null,4]
    //			Output:true
    //			Expected:false
    //			stdout:
    @Test
    public void isSymmetric() {
        Assert.assertEquals(exceptedBoolean, IsSymmetricT101.isSymmetric2(inputTree));

    }
}