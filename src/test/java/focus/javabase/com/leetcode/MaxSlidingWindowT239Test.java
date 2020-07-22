package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given an array nums, there is a sliding window of size k which is moving from
//the very left of the array to the very right. You can only see the k numbers in
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window.
//
// Follow up:
//Could you solve it in linear time?
//
// Example:
//
//
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window

public class MaxSlidingWindowT239Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        inputNum = 3;
        exceptedNums = new int[]{3, 3, 5, 5, 6, 7};

    }

    //    @Before
    public void setUp2() throws Exception {
        inputNums = new int[]{1, 3, 1, 2, 0, 5};
        inputNum = 3;
        exceptedNums = new int[]{3, 3, 2, 5};

    }


    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{1, -1};
        inputNum = 1;
        exceptedNums = new int[]{1, -1};

    }

    @Test
    public void maxSlidingWindow() {
        Assert.assertArrayEquals(exceptedNums, MaxSlidingWindowT239.maxSlidingWindow1(inputNums, inputNum));
    }

    // info
    //			Wrong Answer:
    //			input:[1,-1]
    //			1
    //			Output:[1,1]
    //			Expected:[1,-1]
    //			stdout:
    //
}