package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array.
//
// Example 1:
//
//
//Input: [3,2,3]
//Output: 3
//
// Example 2:
//
//
//Input: [2,2,1,1,1,2,2]
//Output: 2
//

public class MajorityElementT169Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{2, 2, 1, 1, 1, 2, 2};
        exceptedNum = 2;
    }

    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{3, 2, 3};
        exceptedNum = 3;
    }

    @Test
    public void majorityElement() {
        Assert.assertEquals(exceptedNum, MajorityElementT169.majorityElement1(inputNums));
    }
}