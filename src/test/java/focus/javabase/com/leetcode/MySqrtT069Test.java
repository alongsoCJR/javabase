package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
public class MySqrtT069Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 17;
        exceptedNum = 4;
    }

    @Before
    public void setUp1() throws Exception {
        inputNum = 2147483647;
        exceptedNum = 46340;
    }

    @Test
    public void mySqrt() {
        outputNum = MySqrtT069.mySqrt1(inputNum);
        Assert.assertEquals(exceptedNum, outputNum);
    }

    @After
    public void run() {
        System.out.println("int类型Max:" + Integer.MAX_VALUE);
        System.out.println("开方：" + Math.sqrt(Integer.MAX_VALUE));
        System.out.println((0.8 - 0.7) == (0.5 - 0.4));
    }
}