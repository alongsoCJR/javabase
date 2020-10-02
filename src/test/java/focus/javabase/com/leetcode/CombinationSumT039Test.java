package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationSumT039Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{2, 3, 6, 7};
        inputNum = 7;

    }


    @Before
    public void setUp0() throws Exception {
        inputNums = new int[]{2, 2, 5, 3, 4, 7};
        inputNum = 9; // [2,2,5],[2,3,4],[2,7],[2,3,4],[2,7],[5,4]
    }

    @Test
    public void combinationSum() {
        outputArrayList = new CombinationSumT039().combinationSum(inputNums, inputNum);
    }

    @Test
    public void combinationSum0() {
        outputArrayList = new CombinationSumT039().combinationSum0(inputNums, inputNum);
    }
}