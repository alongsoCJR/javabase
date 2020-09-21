package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationTest extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputStr = "abcde";
    }


    //    @Before
    public void setUp0() throws Exception {

        inputNums = new int[]{1, 2, 3};
    }


    @Before
    public void setUp1() throws Exception {

        inputNums = new int[]{2, 2, 5, 3, 4, 7};
        inputNum = 9; // [2,2,5],[2,3,4],[2,7],[2,3,4],[2,7],[5,4]
    }


    @Test
    public void combination() {
        outputArrayList = Combination.combination(inputStr);
    }

    @Test
    public void combinationWithArray() {
        outputArrayList = Combination.combinationWithArray(inputNums);
    }

    @Test
    public void combinationForSum() {
        outputArrayList = Combination.combinationForSum(inputNums, inputNum);
    }
}