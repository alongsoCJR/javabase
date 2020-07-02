package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.VerifyUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once.
//
// Find all the elements of [1, n] inclusive that do not appear in this array.
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space.
//
// Example:
//
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
//
// Related Topics 数组

public class FindDisappearedNumbersT448Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    }

    @Test
    public void findDisappearedNumbers() {
        FindDisappearedNumbersT448.findDisappearedNumbers4(inputNums);
    }
}