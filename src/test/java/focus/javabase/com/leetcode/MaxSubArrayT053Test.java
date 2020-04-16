package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubArrayT053Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        exceptedNum = 6;
    }

    @Test
    public void maxSubArray() {
        outputNum = MaxSubArrayT053.maxSubArray(inputNums);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}