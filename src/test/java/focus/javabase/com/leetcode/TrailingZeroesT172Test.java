package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//Given an integer n, return the number of trailing zeroes in n!.
//
// Example 1:
//
//
//Input: 3
//Output: 0
//Explanation: 3! = 6, no trailing zero.
//
// Example 2:
//
//
//Input: 5
//Output: 1
//Explanation: 5! = 120, one trailing zero.
//
// Note: Your solution should be in logarithmic time complexity.
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)

public class TrailingZeroesT172Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 5;
        exceptedNum = 1;
    }

    //    @Before
    public void setUp1() throws Exception {
        inputNum = 3;
        exceptedNum = 0;
    }


    @Before
    public void setUp2() throws Exception {
        inputNum = 13;
        exceptedNum = 2;
    }

    @Test
    public void trailingZeroes() {
        Assert.assertEquals(exceptedNum, TrailingZeroesT172.trailingZeroes(inputNum));
    }
}