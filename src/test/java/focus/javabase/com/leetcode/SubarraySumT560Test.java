package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubarraySumT560Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 1, 1};
        inputNum = 2;
        exceptedNum = 2;
    }

    //info
    //			Wrong Answer:
    //			input:[0,0,0,0,0,0,0,0,0,0]
    //			0
    //			Output:10
    //			Expected:55


    // Wrong Answer:
    //			input:[28,54,7,-70,22,65,-6]
    //			100
    //			Output:0
    //			Expected:1


    // info: Timed out while waiting for result
    @Test
    public void subarraySum0() {
        Assert.assertEquals(exceptedNum, SubarraySumT560.subarraySum1(inputNums, inputNum));
    }
}