package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.Lists;
import focus.javabase.com.baseTest.VerifyUtils;
import org.junit.Before;
import org.junit.Test;

public class TreeNodePostOrderTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputArrayList = Lists.newArrayList(3, 9, 20, 15, 7);
        inputArrayList2 = Lists.newArrayList(9, 3, 15, 20, 7);
        exceptedArrayList = Lists.newArrayList(9, 15, 7, 20, 3);
    }

    @Test
    public void getPostOrder() {
        VerifyUtils.verifyList(exceptedArrayList, TreeNodePostOrder.getPostOrder(inputArrayList, inputArrayList2));
    }
}