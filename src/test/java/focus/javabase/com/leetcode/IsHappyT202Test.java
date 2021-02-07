package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsHappyT202Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNum = 10;
        exceptedBoolean = true;
    }


//        @Before
    public void setUp1() throws Exception {
        inputNum = 2;
        exceptedBoolean = false;
    }


    // info
    //					Wrong Answer:
    //					input:1
    //					Output:false
    //					Expected:true
    //					stdout:
    @Test
    public void isHappy() {
        Assert.assertEquals(exceptedBoolean, IsHappyT202.isHappy0(inputNum));
    }
}