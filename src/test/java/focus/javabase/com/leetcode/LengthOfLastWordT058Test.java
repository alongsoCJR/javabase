package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLastWordT058Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputStr = "Hello World";
        exceptedNum = 5;
    }

//    @Before
    public void setUp1() throws Exception {
        inputStr = "a ";
        exceptedNum = 1;
    }

    @Test
    public void lengthOfLastWord() {
        outputNum = LengthOfLastWordT058.lengthOfLastWord2(inputStr);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}