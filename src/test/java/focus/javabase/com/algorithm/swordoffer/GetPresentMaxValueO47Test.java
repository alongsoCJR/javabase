package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetPresentMaxValueO47Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputTwoArr = new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        inputNums = new int[]{3, 3};
        exceptedNum = 53;
    }

    @Before
    public void setWaysToDestination() throws Exception {
        inputNums = new int[]{3, 4};
        exceptedNum = 35;
    }

    @Test
    public void getPresentMaxValue() {
        Assert.assertEquals(exceptedNum, GetPresentMaxValueO47.getPresentMaxValue(inputTwoArr, inputNums[0],inputNums[1]));
    }

    @Test
    public void getPresentMaxValue2() {
        Assert.assertEquals(exceptedNum, GetPresentMaxValueO47.getPresentMaxValue2(inputTwoArr, inputNums[0],inputNums[1]));
    }

    @Test
    public void getWaysToDestination() {
        Assert.assertEquals(exceptedNum, GetPresentMaxValueO47.getWaysToDestination(inputNums[0],inputNums[1]));
    }

    @Test
    public void getWaysToDestination2() {
        Assert.assertEquals(exceptedNum, GetPresentMaxValueO47.getWaysToDestination2(inputNums[0],inputNums[1]));
    }
}