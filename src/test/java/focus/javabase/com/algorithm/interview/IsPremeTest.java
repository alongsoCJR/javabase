package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.VerifyUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsPremeTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{2, 5, 10, 18};
        exceptedNums = new int[]{0, 1, 2, 2};
        outputNums = new int[inputNums.length];
    }

    @Test
    public void decompositionWays() {

        for (int i = 0; i < inputNums.length; i++) {
            outputNums[i] = IsPreme.decompositionWays1(inputNums[i]);
        }
        Assert.assertArrayEquals(exceptedNums, outputNums);
    }
}