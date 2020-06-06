package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
//the one that is missing from the array.
//
// Example 1:
//
//
//Input: [3,0,1]
//Output: 2
//
//
// Example 2:
//
//
//Input: [9,6,4,2,3,5,7,0,1]
//Output: 8
//
//
// Note:
//Your algorithm should run in linear runtime complexity. Could you implement it
// using only constant extra space complexity? Related Topics 位运算 数组 数学

public class MissingNumberT136Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{
                9, 6, 4, 2, 3, 5, 7, 0, 1
        };
        exceptedNum = 8;
    }

    @Test
    public void missingNumber() {
        Assert.assertEquals(exceptedNum, MissingNumberT136.missingNumber3(inputNums));
    }
}