package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//

public class PlusOneT066Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 3};
        exceptedNums = new int[]{1, 2, 4};
    }

    //    @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{4, 3, 2, 1};
        exceptedNums = new int[]{4, 3, 2, 2};
    }

//    @Before
    public void setUp2() throws Exception {
        inputNums = new int[]{1, 9, 9};
        exceptedNums = new int[]{2, 0, 0};
    }

        @Before
    public void setUp3() throws Exception {
        inputNums = new int[]{9, 9, 9};
        exceptedNums = new int[]{1, 0, 0, 0};
    }

    @Test
    public void plusOne() {
        outputNums = PlusOneT066.plusOne2(inputNums);
        Assert.assertArrayEquals(exceptedNums, outputNums);
    }
}