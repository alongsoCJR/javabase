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

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{3, 4, 6, 15};
        inputNum = 10;
        exceptedNum = 36;
    }


        @Before
    public void setUp2() throws Exception {
        inputNums = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        inputNum = 10;
        exceptedNum = 30;
    }


//    @Before
    public void setUp3() throws Exception {
        inputNums = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39
                , 40};
        inputNum = 20;
        exceptedNum = 60;
    }

    @Test
    public void testCutForMaxValue() {
        Assert.assertEquals(exceptedNum, GetMaxValueForCut.cutForMaxValue(inputNum, inputNums));
    }

    // 只适用于长度为3的数组
    @Test
    public void testCutForMaxValue1() {
        Assert.assertEquals(exceptedNum, GetMaxValueForCut.cutForMaxValue1(inputNum, inputNums));
    }

    @Test
    public void testCutForMaxValue2() {
        Assert.assertEquals(exceptedNum, GetMaxValueForCut.cutForMaxValue2(inputNum, inputNums));
    }

    @Test
    public void testCutForMaxValue3() {
        Assert.assertEquals(exceptedNum, GetMaxValueForCut.cutForMaxValue3(inputNum, inputNums));
    }

    @Test
    public void testCutForMaxValue4() {
        Assert.assertEquals(exceptedNum, GetMaxValueForCut.cutForMaxValue4(inputNum, inputNums));
    }
}