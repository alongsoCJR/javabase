package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Calculate the sum of two integers a and b, but you are not allowed to use the
//operator + and -.
//
//
// Example 1:
//
//
//Input: a = 1, b = 2
//Output: 3
//
//
//
// Example 2:
//
//
//Input: a = -2, b = 3
//Output: 1
//
//
//
// Related Topics 位运算

public class GetSumT371Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 1;
        exceptedNum = 3;
    }

    @Before
    public void setU1() throws Exception {
        inputNum = 2;
        exceptedNum = 1;
    }

    @Test
    public void getSum() {
        Assert.assertEquals(exceptedNum, GetSumT371.getSum(inputNum, -1));
    }
}