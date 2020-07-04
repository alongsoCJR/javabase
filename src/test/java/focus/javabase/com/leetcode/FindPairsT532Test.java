package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//
//Given an array of integers and an integer k, you need to find the number of un
//ique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair
// (i, j), where i and j are both numbers in the array and their absolute differen
//ce is k.
//
//
//
// Example 1:
//
//Input: [3, 1, 4, 1, 5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5). Altho
//ugh we have two 1s in the input, we should only return the number of unique pair
//s.
//
//
//
// Example 2:
//
//Input:[1, 2, 3, 4, 5], k = 1
//Output: 4
//Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4)
//and (4, 5).
//
//
//
// Example 3:
//
//Input: [1, 3, 1, 5, 4], k = 0
//Output: 1
//Explanation: There is one 0-diff pair in the array, (1, 1).
//
//
//
// Note:
//
// The pairs (i, j) and (j, i) count as the same pair.
// The length of the array won't exceed 10,000.
// All the integers in the given input belong to the range: [-1e7, 1e7].
//
// Related Topics 数组 双指针


public class FindPairsT532Test extends AbstractTest {

    //        @Before
    public void setUp() throws Exception {
        inputNums = new int[]{3, 1, 4, 1, 5};
        inputNum = 2;
        exceptedNum = 2;
    }


    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{1, 2, 3, 4, 5};
        inputNum = 1;
        exceptedNum = 4;
    }


    @Before
    public void setUp2() throws Exception {
        inputNums = new int[]{1, 3, 1, 5, 4};
        inputNum = 0;
        exceptedNum = 1;
    }

    //        @Before
    public void setUp3() throws Exception {
        inputNums = new int[]{1, 1, 1, 2, 1};
        inputNum = 1;
        exceptedNum = 1;
    }

    @Before
    public void setUp4() throws Exception {
        inputNums = new int[]{-1, 0, 0, 1, 0, 0, -1};
        inputNum = 1;
        exceptedNum = 2;
    }

    @Test
    public void findPairs() {
        Assert.assertEquals(exceptedNum, FindPairsT532.findPairs(inputNums, inputNum));
    }


    @Test
    public void findPairs1() {
        Assert.assertEquals(exceptedNum, FindPairsT532.findPairs2(inputNums, inputNum));
    }


    @Test
    public void findPairs3() {
        Assert.assertEquals(exceptedNum, FindPairsT532.findPairs3(inputNums, inputNum));
    }


    // info
    //			Wrong Answer:
    //			input:[1,2,3,4,5]
    //			1
    //			Output:1
    //			Expected:4
    //			stdout:
    //


    // info
    //			Wrong Answer:
    //			input:[1,3,1,5,4]
    //			0
    //			Output:2
    //			Expected:1
    //			stdout:
    //

    // 输入:
    //[1,1,1,2,1]
    //1
    //输出
    //4
    //预期结果
    //1


    // info
    //			Wrong Answer:
    //			input:[-1,0,0,1,0,0,-1]
    //			1
    //			Output:5
    //			Expected:2
    //			stdout:
    //
}