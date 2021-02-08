package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Count the number of prime numbers less than a non-negative number, n.
//
//
// Example 1:
//
//
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//
public class CountPrimesT204Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputNum = 10;
        exceptedNum = 4;
    }


    @Before
    public void setUp0() throws Exception {
        inputNum = 2;
        exceptedNum = 0;
    }

//    @Before
    public void setUp1() throws Exception {
        inputNum = 3;
        exceptedNum = 1;
    }

    @Test
    public void countPrimes() {
        Assert.assertEquals(exceptedNum, CountPrimesT204.countPrimes(inputNum));
    }
}