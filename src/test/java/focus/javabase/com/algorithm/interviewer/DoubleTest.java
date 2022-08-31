package focus.javabase.com.algorithm.interviewer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleTest extends AbstractTest {

//    @Before
//    public void setUp() throws Exception {
//        inputStr = "4";
//        exceptedDouble = new java.lang.Double("2");
//    }


    @Before
    public void setUp() throws Exception {
        inputStr = "8";
    }

    @Before
    public void setUp1() throws Exception {
        inputStrs = new String[]{"1", "14", "16", "23", "25", "36", "99", "100"};
    }


    @Test
    public void sqart() {
        Assert.assertEquals(Math.sqrt(java.lang.Double.parseDouble(inputStr)),
                Double.sqart(java.lang.Double.parseDouble(inputStr)),
                Double.EPS);
    }

    @Test
    public void sqart1() {
        for (String str : inputStrs) {
            Assert.assertEquals(Math.sqrt(java.lang.Double.parseDouble(str)),
                    Double.sqart(java.lang.Double.parseDouble(str)),
                    Double.EPS);

        }
    }
}