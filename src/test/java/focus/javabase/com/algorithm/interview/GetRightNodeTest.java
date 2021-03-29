package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.ConvertUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetRightNodeTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTreeNums = new Integer[]{1, 2, 3, 4, 5, 6, null, 7};
        inputTree = ConvertUtils.convertTreeNode(inputTreeNums);
    }

    @Test
    public void rightView() {
        outputArrayList = GetRightNode.rightView(inputTree);
    }
}