package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationSumT040Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{10, 1, 2, 7, 6, 1, 5};
        inputNum = 8;
    }

    @Test
    public void combinationSum2() {
        outputArrayList = new CombinationSumT040().combinationSum2(inputNums, inputNum);
    }

    // 去重之后存在另一个问题，没有[1,1,6]了


    // 采用排序,排序的写法怎么写？
    @Test
    public void combinationSum3() {
        outputArrayList = new CombinationSumT040().combinationSum3(inputNums, inputNum);
    }
}