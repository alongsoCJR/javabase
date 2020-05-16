package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a non-empty array of integers, every element appears twice except for on
//e. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory?
//
// Example 1:
//
//
//Input: [2,2,1]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,1,2,1,2]
//Output: 4
//
// Related Topics 位运算 哈希表

public class SingleNumberT136Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{2, 2, 1};
        exceptedNum = 1;
    }

    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{4, 1, 2, 1, 2};
        exceptedNum = 4;
    }


    @Test
    public void singleNumber() {
        Assert.assertEquals(exceptedNum, SingleNumberT136.singleNumber1(inputNums));
    }
}