package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 给定一段长度为n英寸的的钢条和一个价格表pi(i=1,2,...,n),求切割钢条方案，使得销售收益rn最大。注意，如果长度为n英寸的钢条价格足够大，最优解有可能就是完全不需要切割，例如下图给除了一个价格表的样例。
 */
public class GetMaxValueForCutTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 5};
        inputNum = 10;
        exceptedNum = 16;
    }

    @Test
    public void testCutForMaxValue() {
        Assert.assertEquals(exceptedNum, GetMaxValueForCut.cutForMaxValue(inputNum, inputNums));
    }
}