package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsUglyNumberT263Test extends AbstractTest {


    @Before
    public void setUp() throws Exception {
        inputNum = 8;
        exceptedBoolean = true;
    }

    @Test
    public void testIsUgly() {
        Assert.assertEquals(exceptedBoolean, IsUglyNumberT263.isUgly(inputNum));
    }
}