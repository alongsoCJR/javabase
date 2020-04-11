package focus.javabase.com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class AStringToIntT008Test {

    /**
     * @Author chenjianrong-lhq
     * @Description 一个算法，设计的思想很重要啊，测试案例由少增多，
     * 最初写的代码也越改越烂，让人都了生硬难懂，当需求变化的时候，设计也应该随之发生改变，否则，就会成为一坨烂泥。
     **/
    @Test
    public void myAtoi() {
        assertEquals(42, AStringToIntT008.myAtoi("42"));
        assertEquals(-42, AStringToIntT008.myAtoi("   -42"));
        assertEquals(4193, AStringToIntT008.myAtoi("4193 with words"));
        assertEquals(0, AStringToIntT008.myAtoi("words and 987"));
        assertEquals(-2147483648, AStringToIntT008.myAtoi("-91283472332"));

        assertEquals(4193, AStringToIntT008.myAtoi("4193a with words"));
        assertEquals(21474836, AStringToIntT008.myAtoi("21474836++"));
        assertEquals(1, AStringToIntT008.myAtoi("+1"));

        /**如何处理这种字符呀，感觉这种字符跟Long类型越界带来冲突**/
        assertEquals(13678217, AStringToIntT008.myAtoi("0000000013678217"));
    }


    @Test
    public void myAtoi1() {
        assertEquals(-42, Long.parseLong("-42"));
        assertEquals(13678217, Long.parseLong("0000000013678217"));
        assertEquals(42, AStringToIntT008.myAtoi1("42"));
        assertEquals(-42, AStringToIntT008.myAtoi1("   -42"));
        assertEquals(4193, AStringToIntT008.myAtoi1("4193 with words"));
        assertEquals(0, AStringToIntT008.myAtoi1("words and 987"));
        assertEquals(-2147483648, AStringToIntT008.myAtoi1("-91283472332"));

        assertEquals(4193, AStringToIntT008.myAtoi1("4193a with words"));
        assertEquals(21474836, AStringToIntT008.myAtoi1("21474836++"));
        assertEquals(1, AStringToIntT008.myAtoi1("+1"));

        assertEquals(13678217, AStringToIntT008.myAtoi1("0000000013678217"));
        assertEquals(2147483647, AStringToIntT008.myAtoi1("12839174472872173122113678217"));

        assertEquals(0, AStringToIntT008.myAtoi1("+"));
        /**空格没有处理好**/
        assertEquals(0, AStringToIntT008.myAtoi1("   +0 123"));
        assertEquals(0, AStringToIntT008.myAtoi1("-   234"));

    }

    @Test
    public void myAtoi2() {
        assertEquals(1<<26,Integer.MAX_VALUE / Integer.SIZE + 1);
        assertEquals(-42, Long.parseLong("-42"));
        assertEquals(13678217, Long.parseLong("0000000013678217"));
        assertEquals(42, AStringToIntT008.myAtoi2("42"));
        assertEquals(-42, AStringToIntT008.myAtoi2("   -42"));
        assertEquals(4193, AStringToIntT008.myAtoi2("4193 with words"));
        assertEquals(0, AStringToIntT008.myAtoi2("words and 987"));
        assertEquals(-2147483648, AStringToIntT008.myAtoi2("-91283472332"));

        assertEquals(4193, AStringToIntT008.myAtoi2("4193a with words"));
        assertEquals(21474836, AStringToIntT008.myAtoi2("21474836++"));
        assertEquals(1, AStringToIntT008.myAtoi2("+1"));

        assertEquals(13678217, AStringToIntT008.myAtoi2("0000000013678217"));
        assertEquals(2147483647, AStringToIntT008.myAtoi2("12839174472872173122113678217"));

        assertEquals(0, AStringToIntT008.myAtoi2("+"));
        /**空格没有处理好**/
        assertEquals(0, AStringToIntT008.myAtoi2("   +0 123"));
        assertEquals(0, AStringToIntT008.myAtoi2("-   234"));
        assertEquals(Integer.MIN_VALUE, AStringToIntT008.myAtoi2("-2147483649"));

    }
}