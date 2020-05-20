package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2.
//
// Note:
//
//
// Your returned answers (both index1 and index2) are not zero-based.
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice.
//
//
// Example:
//
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

public class TwoSumT167Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{2, 7, 11, 15};
        inputNum = 9;
        exceptedNums = new int[]{1, 2};
    }


    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{5, 5, 7, 15};
        inputNum = 10;
        exceptedNums = new int[]{1, 2};
    }


    //info
    //			Finished:
    //			Your input:[5,7,5,15]
    //			10
    //			Output:[1,3]
    //			Expected:[1,3]
    //			stdout:  Map做了一个去重
    @Test
    public void twoSum() {
        outputNums = TwoSumT167.twoSum1(inputNums, inputNum);
        Assert.assertArrayEquals(exceptedNums, outputNums);
    }


}