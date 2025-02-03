package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence.
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
//
// Example 1:
//
//
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
//length is 4.
//
//
// Example 2:
//
//
//Input: nums = [0,1,0,3,2,3]
//Output: 4
//
//
// Example 3:
//
//
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
//
//
//
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time co
//mplexity?
// Related Topics 数组 二分查找 动态规划
// 👍 2826 👎 0
public class LengthOfLIST300Test extends AbstractTest {


    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        exceptedNum = 4;
    }

    @Test
    public void lengthOfLIS() {
        Assert.assertEquals(exceptedNum, LengthOfLIST300.lengthOfLIS(inputNums));

    }
}