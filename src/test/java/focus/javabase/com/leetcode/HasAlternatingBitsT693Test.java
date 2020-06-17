package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given a positive integer, check whether it has alternating bits: namely, if tw
//o adjacent bits will always have different values.
//
// Example 1:
//
//Input: 5
//Output: True
//Explanation:
//The binary representation of 5 is: 101
//
//
//
// Example 2:
//
//Input: 7
//Output: False
//Explanation:
//The binary representation of 7 is: 111.
//
//
//
// Example 3:
//
//Input: 11
//Output: False
//Explanation:
//The binary representation of 11 is: 1011.
//
//
//
// Example 4:
//
//Input: 10
//Output: True
//Explanation:
//The binary representation of 10 is: 1010.
//
// Related Topics 位运算

public class HasAlternatingBitsT693Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 5;
        exceptedBoolean = true;
    }

    //    @Before
    public void setUp1() throws Exception {
        inputNum = 7;
        exceptedBoolean = false;
    }

    //    @Before
    public void setUp2() throws Exception {
        inputNum = 11;
        exceptedBoolean = false;
    }

    @Before
    public void setUp3() throws Exception {
        inputNum = 17;
        exceptedBoolean = false;
    }

    //info
    //			Wrong Answer:
    //			input:4
    //			Output:true
    //			Expected:false
    //			stdout:


    //info
    //			Wrong Answer:
    //			input:17
    //			Output:true
    //			Expected:false
    //			stdout:

    //info
    //			Wrong Answer:
    //			input:6
    //			Output:true
    //			Expected:false
    //			stdout:
    @Test
    public void hasAlternatingBits() {
        Assert.assertEquals(exceptedBoolean, HasAlternatingBitsT693.
                hasAlternatingBits(inputNum));
    }
}