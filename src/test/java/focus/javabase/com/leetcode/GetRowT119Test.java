package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a non-negative index k where k ≤ 33, return the kth index row of the Pas
//cal's triangle.
//
// Note that the row index starts from 0.
//
//
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it.
//
// Example:
//
//
//Input: 3
//Output: [1,3,3,1]
//
//
// Follow up:
//
// Could you optimize your algorithm to use only O(k) extra space?
// Related Topics 数组

public class GetRowT119Test extends AbstractTest {

    Integer[] exceptedNums = null;
    Integer[] outputNums = null;

    @Before
    public void setUp() throws Exception {
        inputNum = 3;
        exceptedNums = new Integer[]{1, 3, 3, 1};
    }

    @Test
    public void getRow() {
        outputArrayList = GetRowT119.getRow(inputNum);
        Integer[] outputNums = new Integer[exceptedNums.length];
        outputArrayList.toArray(outputNums);
        Assert.assertArrayEquals(exceptedNums, outputNums);
    }
}