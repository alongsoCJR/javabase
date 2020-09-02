package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VerifySquenceOfBSTO33Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{5, 7, 6, 9, 11, 10, 8};
        exceptedBoolean = true;
    }


    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{7, 4, 6, 5};
        exceptedBoolean = false;
    }

    //    @Before
    public void setUp2() throws Exception {
        inputNums = new int[]{1, 2, 3, 4};
        exceptedBoolean = true;
    }

    @Test
    public void verifySquenceOfBST() {
        Assert.assertEquals(exceptedBoolean, VerifySquenceOfBSTO33.verifySquenceOfBST(inputNums, 0, inputNums.length - 1));
    }
}