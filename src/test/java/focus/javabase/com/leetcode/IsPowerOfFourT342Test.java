package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given an integer (signed 32 bits), write a function to check whether it is a p
//ower of 4.
//
// Example 1:
//
//
//Input: 16
//Output: true
//
//
//
// Example 2:
//
//
//Input: 5
//Output: false
//
//
// Follow up: Could you solve it without loops/recursion? Related Topics 位运算


public class IsPowerOfFourT342Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNum = 16;
        exceptedBoolean = true;
    }

    @Test
    public void isPowerOfFour() {
        Assert.assertEquals(exceptedBoolean, IsPowerOfFourT342.isPowerOfFour2(inputNum));
    }
}