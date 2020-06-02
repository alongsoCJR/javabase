package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//Reverse bits of a given 32 bits unsigned integer.
//
//
//
// Example 1:
//
//
//Input: 00000010100101000001111010011100
//Output: 00111001011110000010100101000000
//Explanation: The input binary string 00000010100101000001111010011100 represen
//ts the unsigned integer 43261596, so return 964176192 which its binary represent
//ation is 00111001011110000010100101000000.
//
//
// Example 2:
//
//
//Input: 11111111111111111111111111111101
//Output: 10111111111111111111111111111111
//Explanation: The input binary string 11111111111111111111111111111101 represen
//ts the unsigned integer 4294967293, so return 3221225471 which its binary repres
//entation is 10111111111111111111111111111111.
//
//
//
// Note:
//
//
// Note that in some languages such as Java, there is no unsigned integer type.
//In this case, both input and output will be given as signed integer type and sho
//uld not affect your implementation, as the internal binary representation of the
// integer is the same whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement not
//ation. Therefore, in Example 2 above the input represents the signed integer -3
//and the output represents the signed integer -1073741825.
//
//
//
//
// Follow up:
//
// If this function is called many times, how would you optimize it?
public class ReverseBitsT190Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputStr = "00000010100101000001111010011100";
        exceptedStr = "00111001011110000010100101000000";
    }


    @Before
    public void setUp1() throws Exception {
        inputStr = "00000000000000000000000000001111";
        exceptedStr = "11110000000000000000000000000000";
    }

    @Test
    public void reverseBits() {
        inputNum = Integer.parseUnsignedInt(inputStr, 2);
        exceptedNum = Integer.parseUnsignedInt(exceptedStr, 2);
        Assert.assertEquals(exceptedNum, ReverseBitsT190.reverseBits(inputNum));

    }

    //info
    //			Wrong Answer:
    //			input:11111111111111111111111111111101
    //			Output:           0 (00000000000000000000000000000000)
    //			Expected:  3221225471 (10111111111111111111111111111111)
    //			stdout:
    @Test
    public void reverseBits1() {
        inputNum = Integer.parseUnsignedInt(inputStr, 2);
        exceptedNum = Integer.parseUnsignedInt(exceptedStr, 2);
        Assert.assertEquals(exceptedNum, ReverseBitsT190.reverseBits2(inputNum));

    }
}