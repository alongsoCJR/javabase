package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementT027Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{3, 2, 2, 3};
        inputNum = 3;
        exceptedNum = 2;
    }


    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        inputNum = 2;
        exceptedNum = 5;
    }

    //info
    //			Wrong Answer:
    //			input:[0,1,2,2,3,0,4,2]
    //			2
    //			Output:[0,1,2,3,0]
    //			Expected:[0,1,4,0,3]
    @Test
    public void removeElement() {
        outputNum = RemoveElementT027.removeElement1(inputNums, inputNum);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}