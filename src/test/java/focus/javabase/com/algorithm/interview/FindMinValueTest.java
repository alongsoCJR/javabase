package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindMinValueTest extends AbstractTest {

    @Before
    public void setUp0() throws Exception {
        inputNums = new int[]{2, 2, 2, 0, 1};
        exceptedNum = 0;
    }

    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{3, 4, 5, 1, 2};
        exceptedNum = 1;
    }

//    @Before
    public void setUp2() throws Exception {
        inputNums = new int[]{3, 3, 1, 3};
        exceptedNum = 1;
    }


//    @Before
    public void setUp3() throws Exception {
        inputNums = new int[]{1, 1};
        exceptedNum = 1;
    }

    @Test
    public void minArray() {
        Assert.assertEquals(exceptedNum, FindMinValue.minArray(inputNums));
    }

    //    @Before
    public void setUpBinarySearch() throws Exception {
        inputNums = new int[]{1, 2, 3, 4, 5, 6};
        inputNum = 4;
        exceptedNum = 3;
    }

    @Test
    public void binarySearch() {
        Assert.assertEquals(exceptedNum, FindMinValue.binarySearch(inputNums, inputNum));
    }

    @Test
    public void minArray0() {
        Assert.assertEquals(exceptedNum, FindMinValue.minArray0(inputNums));
    }
}