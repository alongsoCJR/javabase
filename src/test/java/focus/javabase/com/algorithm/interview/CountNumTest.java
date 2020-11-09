package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumTest extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 3, 2, 1, 2, 3, 4, 5, 10, 12};
        exceptedNum = 2;
    }

    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{1, 2, 0, 1, 1, 3, 2, 1, 2, 3, 4, 5, 10, 12};
        exceptedNum = 1;
    }

    @Test
    public void countNum() {
//        Assert.assertEquals(exceptedNum, CountNum.countNum1(inputNums));
    }
}