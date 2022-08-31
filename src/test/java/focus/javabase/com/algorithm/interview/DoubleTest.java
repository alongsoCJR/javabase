package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ks面试题
 */
public class DoubleTest extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputStr = "123.11121";
        exceptedDouble = 123.11121;
    }


//    @Before
    public void setUp2() throws Exception {
        inputStr = "3.11121";
        exceptedDouble = 3.11121;
    }

    @Before
    public void setUp3() throws Exception {
        inputStr = "0.11121";
        exceptedDouble = 0.11121;
    }

    @Test
    public void testParseDouble() {
        Assert.assertEquals(exceptedDouble, Double.parseDouble(inputStr), 0);
    }


}