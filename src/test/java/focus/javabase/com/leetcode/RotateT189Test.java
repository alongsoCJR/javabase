package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive.
//
// Follow up:
//
//
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem.
// Could you do it in-place with O(1) extra space?
//
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//
// Example 2:
//
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 10^4
// It's guaranteed that nums[i] fits in a 32 bit-signed integer.
// k >= 0
//
// Related Topics 数组


public class RotateT189Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 3, 4, 5, 6, 7};
        inputNum = 3;
        exceptedNums = new int[]{5, 6, 7, 1, 2, 3, 4};
    }


    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{-1, -100, 3, 99};
        inputNum = 2;
        exceptedNums = new int[]{3, 99, -1, -100};
    }


    @Test
    public void rotate() {
        RotateT189.rotate(inputNums, inputNum);
        Assert.assertArrayEquals(exceptedNums, inputNums);
    }


    //info
    //			Wrong Answer:
    //			input:[-1,-100,3,99]
    //			2
    //			Output:[-1,-100,3,99]
    //			Expected:[3,99,-1,-100]
    //			stdout:
    //
    @Test
    public void rotate1() {
        RotateT189.rotate1(inputNums, inputNum);
        Assert.assertArrayEquals(exceptedNums, inputNums);
    }


    @Test
    public void rotate2() {
        RotateT189.rotate2(inputNums, inputNum);
        Assert.assertArrayEquals(exceptedNums, inputNums);
    }

    @Test
    public void rotate3() {
        RotateT189.rotate3(inputNums, inputNum);
        Assert.assertArrayEquals(exceptedNums, inputNums);
    }


}