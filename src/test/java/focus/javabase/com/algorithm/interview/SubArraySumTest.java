package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubArraySumTest extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {

        inputNums = new int[]{1, 1, 1};
        inputNum = 2;

    }


    @Before
    public void setUp0() throws Exception {
        inputNums = new int[]{2, 2, 3, 4, 5, 7};
        inputNum = 9;

    }


    // 6个结果
    // [2,3,4],[2,2,5],[2,7]
    // [2,3,4],[2,7]
    // [4,5]
    @Test
    public void subarraySum() {
        outputArrayList = SubArraySum.subarraySum(inputNums, inputNum);
    }
}