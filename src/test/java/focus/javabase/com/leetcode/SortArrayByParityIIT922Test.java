package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given an array A of non-negative integers, half of the integers in A are odd,
//and half of the integers are even.
//
// Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is e
//ven, i is even.
//
// You may return any answer array that satisfies this condition.
//
//
//
// Example 1:
//
//
//Input: [4,2,5,7]
//Output: [4,5,2,7]
//Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
//
//
//
// Note:
//
//
// 2 <= A.length <= 20000
// A.length % 2 == 0
// 0 <= A[i] <= 1000
//
//
//
//
// Related Topics 排序 数组

public class SortArrayByParityIIT922Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{4, 2, 5, 7};
        exceptedNums = new int[]{4, 5, 2, 7};
    }

    @Test
    public void sortArrayByParityII() {
        Assert.assertArrayEquals(exceptedNums, SortArrayByParityIIT922.sortArrayByParityII(inputNums));
    }

    @Test
    public void sortArrayByParityII1() {
        Assert.assertArrayEquals(exceptedNums, SortArrayByParityIIT922.sortArrayByParityII1(inputNums));
    }

    @Test
    public void sortArrayByParityII2() {
        Assert.assertArrayEquals(exceptedNums, SortArrayByParityIIT922.sortArrayByParityII2(inputNums));
    }
}