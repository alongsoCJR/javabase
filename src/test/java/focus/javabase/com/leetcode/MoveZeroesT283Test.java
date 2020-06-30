package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.VerifyUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements.
//
// Example:
//
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
//
// Note:
//
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
// Related Topics 数组 双指针

public class MoveZeroesT283Test extends AbstractTest {

    //@Before
    public void setUp() throws Exception {
        inputNums = new int[]{0, 1, 0, 3, 12};
        exceptedNums = new int[]{1, 3, 12, 0, 0};
    }


    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        exceptedNums = new int[]{4, 2, 4, 3, 5, 1, 0, 0, 0, 0};
    }


    //    @Before
    public void setUp3() throws Exception {
        inputNums = new int[]{1, 0, 1};
        exceptedNums = new int[]{1, 1, 0};
    }


    @Test
    public void moveZeroes() {
        MoveZeroesT283.moveZeroes(inputNums);
        VerifyUtils.verifyArrays(exceptedNums, inputNums);
    }


    //info
    //			Wrong Answer:
    //			input:[4,2,4,0,0,3,0,5,1,0]
    //			Output:[4,0,0,0,0,3,2,5,1,4]
    //			Expected:[4,2,4,3,5,1,0,0,0,0]
    //			stdout:
    //


    //info
    //			Wrong Answer:
    //			input:[1,0,1]
    //			Output:[1,0,1]
    //			Expected:[1,1,0]
    //			stdout:
    @Test
    public void moveZeroes2() {
        MoveZeroesT283.moveZeroes2(inputNums);
        VerifyUtils.verifyArrays(exceptedNums, inputNums);
    }
}