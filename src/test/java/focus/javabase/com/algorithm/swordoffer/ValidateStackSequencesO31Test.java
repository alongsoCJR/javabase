package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateStackSequencesO31Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 3, 4, 5};
        outputNums = new int[]{4, 5, 3, 2, 1};
        exceptedBoolean = true;
    }

    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{1, 2, 3, 4, 5};
        outputNums = new int[]{4, 3, 5, 1, 2};
        exceptedBoolean = false;
    }

    @Test
    public void validateStackSequences() {
        Assert.assertEquals(exceptedBoolean,
                ValidateStackSequencesO31.validateStackSequences0(inputNums, outputNums));
    }
}