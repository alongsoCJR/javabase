package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

public class PowerO16Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputDouble = 3;
        inputNum = 4;
    }

//    @Before
    public void setUp1() throws Exception {
        inputDouble = 2.00000;
        inputNum = -2147483648;
    }

    @Before
    public void setUp2() throws Exception {
        inputDouble = 42.38803;
        inputNum = 1;
    }

    @Test
    public void testPower() {
        System.out.println(PowerO16.power(inputDouble, inputNum));
    }

    //info
    //						Wrong Answer:
    //						input:2.00000
    //						-2147483648
    //						Output:1.00000
    //						Expected:0.0
    //						stdout:
    @Test
    public void testPower1() {
        System.out.println(PowerO16.power1(inputDouble, inputNum));
    }

    // info
    //						Compile Error:
    //						Time Limit Exceeded
    //						Your input:-1.00000
    //						2147483647
    //						stdout:


    // 10:09 AM	info
    //						Wrong Answer:
    //						input:42.38803
    //						1
    //						Output:1.00000
    //						Expected:42.38803
    //						stdout:
    @Test
    public void testPower2() {
        System.out.println(PowerO16.power2(inputDouble, inputNum));
    }
}