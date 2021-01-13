package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetPresentMaxValueO47Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTwoArr = new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        inputNums = new int[]{3, 3};
        exceptedNum = 53;
    }

    @Test
    public void getPresentMaxValue() {
//        System.out.println(inputTwoArr[0][1]);
        Assert.assertEquals(exceptedNum, GetPresentMaxValueO47.getPresentMaxValue(inputTwoArr, inputNums[0],inputNums[1]));

    }
}