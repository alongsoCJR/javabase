package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Suppose you have a long flowerbed in which some of the plots are planted and s
//ome are not. However, flowers cannot be planted in adjacent plots - they would c
//ompete for water and both would die.
//
// Given a flowerbed (represented as an array containing 0 and 1, where 0 means
//empty and 1 means not empty), and a number n, return if n new flowers can be pla
//nted in it without violating the no-adjacent-flowers rule.
//
// Example 1:
//
//Input: flowerbed = [1,0,0,0,1], n = 1
//Output: True
//
//
//
// Example 2:
//
//Input: flowerbed = [1,0,0,0,1], n = 2
//Output: False
//
//
//
// Note:
//
// The input array won't violate no-adjacent-flowers rule.
// The input array size is in the range of [1, 20000].
// n is a non-negative integer which won't exceed the input array size.
//
// Related Topics 数组

public class CanPlaceFlowersTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 0, 1, 0, 0, 1,};
        inputNum = 1;
        exceptedBoolean = false;
    }

    //  info
    //			Wrong Answer:
    //			input:[0,1,0]
    //			1
    //			Output:true
    //			Expected:false
    //			stdout:
    @Test
    public void canPlaceFlowers() {
        Assert.assertEquals(exceptedBoolean, CanPlaceFlowers.canPlaceFlowers1(inputNums, inputNum));
    }


    //info
    //			Wrong Answer:
    //			input:[0,0,1,0,1]
    //			1
    //			Output:false
    //			Expected:true
    //			stdout:


    //info
    //			Wrong Answer:
    //			input:[1,0,1,0,0,1,0]
    //			1
    //			Output:true
    //			Expected:false
    //			stdout:


    //info
    //			Wrong Answer:
    //			input:[1,0,0,0,0,1]
    //			2
    //			Output:true
    //			Expected:false
    //			stdout:
}