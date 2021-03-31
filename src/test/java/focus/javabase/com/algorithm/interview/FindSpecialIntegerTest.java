package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindSpecialIntegerTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10};
        exceptedNum = 6;
    }

    @Test
    public void findSpecialInteger() {
        Assert.assertEquals(exceptedNum, FindSpecialInteger.findSpecialInteger0(inputNums));
    }
}