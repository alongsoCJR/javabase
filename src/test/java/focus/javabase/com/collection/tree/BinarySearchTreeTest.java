package focus.javabase.com.collection.tree;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{5, 3, 1, 4, 7, 6};
    }


    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{5, 3, 1, 4, 7, 6, 8, 7, 1, 2, 32, 5, 63, 1000};
    }

    @Test
    public void create() {
        outputTree = BinarySearchTree.create(inputNums);
        outputNums = BinarySearchTree.inorder(outputTree);
    }
}