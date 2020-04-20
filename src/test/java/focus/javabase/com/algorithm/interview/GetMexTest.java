package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetMexTest extends AbstractTest {

    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{1, 2, 3, 5, 6, 3, 2};
        inputNum = 7;
        exceptedNum = 4;
    }

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 3, 4, 5, 6, 3, 2,7};
        inputNum = 7;
        exceptedNum = -1;
    }

    @Test
    public void getMex() {
        Assert.assertEquals(exceptedNum, GetMex.getMex1(inputNums, inputNum));
    }
}