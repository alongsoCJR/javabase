package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
// 26*6=156+520=676+25=701
// Related Topics 数学


public class ConvertToTitleT168Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 701;
        exceptedStr = "ZY";
    }


    //    @Before
    public void setUp1() throws Exception {
        inputNum = 703;
        exceptedStr = "AAA";
    }


    @Before
    public void setUp2() throws Exception {
        inputNum = 26;
        exceptedStr = "Z";
    }


    @Before
    public void setUp3() throws Exception {
        inputNum = 52;
        exceptedStr = "Z";
    }


    @Before
    public void setUp4() throws Exception {
        inputNum = 702;
        exceptedStr = "Z";
    }

    //info
//			Wrong Answer:
//			input:52
//			Output:"BZ"
//			Expected:"AZ"
//			stdout:
    @Test
    public void convertToTitle() {
        Assert.assertEquals(exceptedStr, ConvertToTitleT168.convertToTitle(inputNum));
    }
}