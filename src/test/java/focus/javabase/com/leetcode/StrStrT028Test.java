package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrStrT028Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputStr = "hello";
        exceptedStr = "ll";
        exceptedNum = 2;
    }

//    @Before
    public void setUp1() throws Exception {
        inputStr = "aaaaa";
        exceptedStr = "bba";
        exceptedNum = -1;
    }

    //info
    //			Wrong Answer:
    //			input:"mississippi"
    //			"pi"
    //			Output:-1
    //			Expected:9
    @Before
    public void setUp2() throws Exception {
        inputStr = "mississippi";
        exceptedStr = "pi";
        exceptedNum = 9;
    }

    @Test
    public void strStr() {
        outputNum = StrStrT028.strStr(inputStr, exceptedStr);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}