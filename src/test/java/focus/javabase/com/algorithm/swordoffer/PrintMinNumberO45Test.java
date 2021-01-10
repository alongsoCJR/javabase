package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Jianrong.Chen
 * @Description 给定一个数组，返回数组排成的最小的数
 * @Date 2021-01-10 09:38
 **/
public class PrintMinNumberO45Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{3, 32, 321};
        exceptedNum = 321323;
    }

    @Test
    public void printMinNumber() {
        Assert.assertEquals(exceptedNum, PrintMinNumberO45.printMinNumber(inputNums));
    }
}