package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibon
//acci sequence, such that each number is the sum of the two preceding ones, start
//ing from 0 and 1. That is,
//
//
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), for N > 1.
//
//
// Given N, calculate F(N).
//
//
//
// Example 1:
//
//
//Input: 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//
//
// Example 2:
//
//
//Input: 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//
//
// Example 3:
//
//
//Input: 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
//
//
//
//
// Note:
//
// 0 ≤ N ≤ 30.
// Related Topics 数组

public class FibT509Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNum = 12;
        exceptedNum = 144;
    }

    @Test
    public void fib() {
        Assert.assertEquals(exceptedNum, FibT509.iterativelyFib(inputNum));
    }
}