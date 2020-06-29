package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a non-empty array of integers, return the third maximum number in this a
//rray. If it does not exist, return the maximum number. The time complexity must
//be in O(n).
//
// Example 1:
//
//Input: [3, 2, 1]
//
//Output: 1
//
//Explanation: The third maximum is 1.
//
//
//
// Example 2:
//
//Input: [1, 2]
//
//Output: 2
//
//Explanation: The third maximum does not exist, so the maximum (2) is returned
//instead.
//
//
//
// Example 3:
//
//Input: [2, 2, 3, 1]
//
//Output: 1
//
//Explanation: Note that the third maximum here means the third maximum distinct
// number.
//Both numbers with value 2 are both considered as second maximum.
//
// Related Topics 数组

public class ThirdMaxT414Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{-2147483648, 1, 1};
        exceptedNum = 1;
    }

    //info
    //			Wrong Answer:
    //			input:[1,2,-2147483648]
    //			Output:2
    //			Expected:-2147483648
    //			stdout:
    @Test
    public void thirdMax() {
        Assert.assertEquals(exceptedNum, ThirdMaxT414.thirdMax(inputNums));
    }

    //info
    //			Wrong Answer:
    //			input:[-2147483648,1,1]
    //			Output:-2147483648
    //			Expected:1
    //			stdout:
    @Test
    public void thirdMax1() {
        Assert.assertEquals(exceptedNum, ThirdMaxT414.thirdMax1(inputNums));
    }
}