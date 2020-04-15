package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountAndSayT038Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 4;
        exceptedStr = "1211";
    }


    @Before
    public void setUp1() throws Exception {
        inputNum = 7;
        exceptedStr = "13112221";
    }

    @Test
    public void countAndSay() {
        outputStr = CountAndSayT038.countAndSay1(inputNum);
        Assert.assertEquals(exceptedStr, outputStr);
    }
}