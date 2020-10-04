package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author chenjianrong-lhq
 * @Description 剑指offer第4题 二维数组
 * @Date 2020-10-04 16:42
 **/
public class FindNumO004Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputTwoArr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        inputNum = 7;
        exceptedBoolean = true;
    }


    //    @Before
    public void setUp0() throws Exception {
        inputTwoArr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 6, 10, 13}, {6, 8, 11, 15}};
        inputNum = 7;
        exceptedBoolean = false;
    }

    @Test
    public void find() {
        Assert.assertEquals(exceptedBoolean, FindNumO004.find(inputTwoArr, inputNum));
    }
}