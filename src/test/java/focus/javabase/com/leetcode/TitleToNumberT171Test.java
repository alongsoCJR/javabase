package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a column title as appear in an Excel sheet, return its corresponding col
//umn number.
//
// For example:
//
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
// Example 1:
//
//
//Input: "A"
//Output: 1
//
//
// Example 2:
//
//
//Input: "AB"
//Output: 28
//
//
// Example 3:
//
//
//Input: "ZY"
//Output: 701
// Related Topics 数学

public class TitleToNumberT171Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputStr = "ZY";
        exceptedNum = 701;
    }

    @Test
    public void titleToNumber() {
        Assert.assertEquals(exceptedNum, TitleToNumberT171.titleToNumber(inputStr));
    }
}