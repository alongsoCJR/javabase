package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixT014Test extends AbstractTest {

    public static String[] strings = null;

    public static String exceptedReturn = null;

    @Before
    public void setUp() {
        strings = new String[]{"flower", "flow", "flight","fling"};
        exceptedReturn = "fl";
    }

//    @Before
//    public void setUp() {
//        strings = new String[]{"dog", "racecar", "car"};
//        exceptedReturns = "";
//    }

    @Test
    public void longestCommonPrefix() {
        String actualReturn = LongestCommonPrefixT014.longestCommonPrefixByRecursion(strings);
        assertEquals(exceptedReturn, actualReturn);
    }
}