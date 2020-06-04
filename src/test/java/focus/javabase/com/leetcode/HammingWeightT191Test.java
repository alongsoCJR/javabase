package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Write a function that takes an unsigned integer and return the number of '1' b
//its it has (also known as the Hamming weight).
//
//
//
// Example 1:
//
//
//Input: 00000000000000000000000000001011
//Output: 3
//Explanation: The input binary string 00000000000000000000000000001011 has a to
//tal of three '1' bits.
//
//
// Example 2:
//
//
//Input: 00000000000000000000000010000000
//Output: 1
//Explanation: The input binary string 00000000000000000000000010000000 has a to
//tal of one '1' bit.
//
//
// Example 3:
//
//
//Input: 11111111111111111111111111111101
//Output: 31
//Explanation: The input binary string 11111111111111111111111111111101 has a to
//tal of thirty one '1' bits.
//
//
//
// Note:
//
//
// Note that in some languages such as Java, there is no unsigned integer type.
//In this case, the input will be given as signed integer type and should not affe
//ct your implementation, as the internal binary representation of the integer is
//the same whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement not
//ation. Therefore, in Example 3 above the input represents the signed integer -3.
//
//
//
//
//
// Follow up:
//
// If this function is called many times, how would you optimize it?
// Related Topics 位运算

public class HammingWeightT191Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputStr = "00000000000000000000000000001011";
        inputNum = Integer.parseUnsignedInt(inputStr, 2);
        exceptedNum = 3;
    }


    //    @Before
    public void setUp1() throws Exception {
        inputStr = "11111111111111111111111111111101";
        inputNum = Integer.parseUnsignedInt(inputStr, 2);
        exceptedNum = 31;
    }

    @Test
    public void hammingWeight() {
        Assert.assertEquals(exceptedNum, HammingWeightT191.hammingWeight2(inputNum));
    }
}