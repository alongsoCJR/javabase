package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//
//Given an integer, write an algorithm to convert it to hexadecimal. For negativ
//e integer, two’s complement method is used.
//
//
// Note:
//
// All letters in hexadecimal (a-f) must be in lowercase.
// The hexadecimal string must not contain extra leading 0s. If the number is ze
//ro, it is represented by a single zero character '0'; otherwise, the first chara
//cter in the hexadecimal string will not be the zero character.
// The given number is guaranteed to fit within the range of a 32-bit signed int
//eger.
// You must not use any method provided by the library which converts/formats th
//e number to hex directly.
//
//
//
// Example 1:
//
//Input:
//26
//
//Output:
//"1a"
//
//
//
// Example 2:
//
//Input:
//-1
//
//Output:
//"ffffffff"
//
// Related Topics 位运算

public class toHexT405Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 26;
        exceptedStr = "1a";
    }

    @Before
    public void setUp1() throws Exception {
        inputNum = -1;
        exceptedStr = "ffffffff";
    }

    // 如何解决负数的问题
    @Test
    public void toHex() {
        Assert.assertEquals(exceptedStr, ToHexT405.toHex(inputNum));
    }
}