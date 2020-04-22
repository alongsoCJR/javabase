package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
public class ClimbStairsT070Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputNum = 5;
        exceptedNum = 8;
    }

    @Before
    public void setUp1() throws Exception {
        inputNum = 16;
        exceptedNum = 1597;
    }


    @Test
    public void climbStairs() {
        outputNum = ClimbStairsT070.climbStairs1(inputNum);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}