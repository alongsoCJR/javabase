package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Say you have an array for which the ith element is the price of a given stock
//on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t.
//
// Note that you cannot sell a stock before you buy one.
//
// Example 1:
//
//
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
//
//
// Example 2:
//
//
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
public class MaxProfitT121Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{7, 1, 5, 3, 6, 4};
        exceptedNum = 5;
    }

    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{7, 6, 4, 3, 1};
        exceptedNum = 0;
    }

    @Test
    public void maxProfit() {
        outputNum = MaxProfitT121.maxProfit(inputNums);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}