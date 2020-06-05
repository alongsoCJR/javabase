package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given an integer, write a function to determine if it is a power of two.
//
// Example 1:
//
//
//Input: 1
//Output: true
//Explanation: 20 = 1
//
//
// Example 2:
//
//
//Input: 16
//Output: true
//Explanation: 24 = 16
//
// Example 3:
//
//
//Input: 218
//Output: false
// Related Topics 位运算 数学

public class IsPowerOfTwoT231Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 218;
        exceptedBoolean = false;
    }

    //    @Before
    public void setUp1() throws Exception {
        inputNum = 16;
        exceptedBoolean = true;
    }

    //info
    //			Wrong Answer:
    //			input:5
    //			Output:true
    //			Expected:false
    //			stdout:
    @Before
    public void setUp2() throws Exception {
        inputNum = 5;
        exceptedBoolean = false;
    }

    @Test
    public void isPowerOfTwo() {
        Assert.assertEquals(exceptedBoolean, IsPowerOfTwoT231.isPowerOfTwo1(inputNum));
    }
}