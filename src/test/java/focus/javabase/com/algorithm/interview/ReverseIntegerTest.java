package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.VerifyUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest extends AbstractTest {

    @Before
    public void setUp() {
        inputNums = new int[]{1234, 1200, 1002, 12345, -100, 0};
        exceptedNums = new int[]{4321, 21, 2001, 54321, -1, 0};
    }

    @Test
    public void reverseInteger() {
        outputNums = new int[inputNums.length];
        for (int i = 0; i < inputNums.length; i++) {
            outputNums[i] = ReverseInteger.reverseInteger1(inputNums[i]);
        }
        VerifyUtils.verifyArrays(exceptedNums, outputNums);
    }
}