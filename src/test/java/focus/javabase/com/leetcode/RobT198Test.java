package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into
//on the same night.
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police.
//
// Example 1:
//
//
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//
// Example 2:
//
//
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
//
// Related Topics 动态规划

public class RobT198Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 3, 1};
        exceptedNum = 4;
    }


    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{2, 7, 9, 3, 1};
        exceptedNum = 12;
    }


    //exclude patterns:测试时间总耗时：65445ms
    //
    //java.lang.AssertionError:
    //Expected :12000
    //Actual   :4173
    @Before
    public void setUp2() throws Exception {
//        inputNums = new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        inputNums = new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        exceptedNum = 12000;
    }


    // 1 {3,1} + {2,3,1}
    @Test
    public void rob() {
        Assert.assertEquals(exceptedNum, RobT198.rob(inputNums));
    }
}