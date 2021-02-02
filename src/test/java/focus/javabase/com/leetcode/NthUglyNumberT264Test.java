package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NthUglyNumberT264Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNum = 10;
        exceptedNum = 12;
    }

    //Input: n = 10
    //Output: 12

    // Time Limit Exceeded
    // Your input:1352
    @Test
    public void nthUglyNumber() {
        Assert.assertEquals(exceptedNum, NthUglyNumberT264.nthUglyNumber(inputNum));
    }

    @Test
    public void nthUglyNumber0() {
        Assert.assertEquals(exceptedNum, NthUglyNumberT264.nthUglyNumber0(inputNum));
    }
}