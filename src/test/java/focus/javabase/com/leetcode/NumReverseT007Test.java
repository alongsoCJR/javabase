package focus.javabase.com.leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class NumReverseT007Test {

    @Test
    public void reverse0() {
        /**
         * [输入,输出]:
         *              [123,321]
         *             [-123,-321]
         *             [120,21]
         * **/
        assertEquals(0, NumReverseT007.reverse0(0));
        assertEquals(123, NumReverseT007.reverse0(321));
        assertEquals(-321, NumReverseT007.reverse0(-123));
        assertEquals(21, NumReverseT007.reverse0(120));
        assertEquals(201, NumReverseT007.reverse0(102));
        assertEquals(-201, NumReverseT007.reverse0(-102));
        assertEquals(201, NumReverseT007.reverse0(1020000));
        assertEquals(0, NumReverseT007.reverse0(-2147483648));
    }


    @Test
    public void reverse1() {
        /**
         * [输入,输出]:
         *              [123,321]
         *             [-123,-321]
         *             [120,21]
         * **/
        assertEquals(0, NumReverseT007.reverse1(0));
        assertEquals(123, NumReverseT007.reverse1(321));
        assertEquals(-321, NumReverseT007.reverse1(-123));
        assertEquals(21, NumReverseT007.reverse1(120));
        assertEquals(201, NumReverseT007.reverse1(102));
        assertEquals(-201, NumReverseT007.reverse1(-102));
        assertEquals(201, NumReverseT007.reverse1(1020000));
        assertEquals(0, NumReverseT007.reverse1(-2147483648));
    }


    @Test
    public void reverse2() {
        /**
         * [输入,输出]:
         *              [123,321]
         *             [-123,-321]
         *             [120,21]
         * **/
//        assertEquals(0, NumReverseT007.reverse2(0));
        assertEquals(123, NumReverseT007.reverse2(321));
        assertEquals(-321, NumReverseT007.reverse2(-123));
        assertEquals(21, NumReverseT007.reverse2(120));
        assertEquals(201, NumReverseT007.reverse2(102));
        assertEquals(-201, NumReverseT007.reverse2(-102));
        assertEquals(201, NumReverseT007.reverse2(1020000));
        assertEquals(0, NumReverseT007.reverse2(-2147483648));
    }


    @Test
    public void reverse3() {
        /**
         * [输入,输出]:
         *              [123,321]
         *             [-123,-321]
         *             [120,21]
         * **/
        assertEquals(0, NumReverseT007.reverse3(0));
        assertEquals(123, NumReverseT007.reverse3(321));
        assertEquals(-321, NumReverseT007.reverse3(-123));
        assertEquals(21, NumReverseT007.reverse3(120));
        assertEquals(201, NumReverseT007.reverse3(102));
        assertEquals(-201, NumReverseT007.reverse3(-102));
        assertEquals(201, NumReverseT007.reverse3(1020000));
        assertEquals(0, NumReverseT007.reverse3(-2147483648));
    }


    @Test
    public void reverse4() {
        /**
         * [输入,输出]:
         *              [123,321]
         *             [-123,-321]
         *             [120,21]
         * **/
        assertEquals(0, NumReverseT007.reverse4(0));
        assertEquals(123, NumReverseT007.reverse4(321));
        assertEquals(-321, NumReverseT007.reverse4(-123));
        assertEquals(21, NumReverseT007.reverse4(120));
        assertEquals(201, NumReverseT007.reverse4(102));
        assertEquals(-201, NumReverseT007.reverse4(-102));
        assertEquals(201, NumReverseT007.reverse4(1020000));
        assertEquals(0, NumReverseT007.reverse4(-2147483648));
    }


    @Test
    public void reverse5() {
        /**
         * [输入,输出]:
         *              [123,321]
         *             [-123,-321]
         *             [120,21]
         * **/
        /**what happand?  运算符的计算顺序 '*' > '+' > '^'**/
        assertEquals(63, 51L + 1 * 10 ^ 2);
        assertEquals(0, NumReverseT007.reverse5(0));
        assertEquals(123, NumReverseT007.reverse5(321));
        assertEquals(-321, NumReverseT007.reverse5(-123));
        assertEquals(21, NumReverseT007.reverse5(120));
        assertEquals(201, NumReverseT007.reverse5(102));
        assertEquals(-201, NumReverseT007.reverse5(-102));
        assertEquals(201, NumReverseT007.reverse5(1020000));
        assertEquals(0, NumReverseT007.reverse5(-2147483648));
        assertEquals(0, NumReverseT007.reverse5(1534236469));
    }

}