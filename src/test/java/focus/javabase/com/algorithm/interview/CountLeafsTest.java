package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.ConvertUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CountLeafsTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTreeNums = new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        inputTree = ConvertUtils.convertTreeNode(inputTreeNums);
        exceptedNum = 5;
    }

    @Test
    public void countLeaf() {
        Assert.assertEquals(exceptedNum, CountLeafs.countLeaf(inputTree));
    }
}