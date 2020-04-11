package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Test;

public class RomanToIntT013Test extends AbstractTest {

    public static String[] romanStrings = {"III", "IV", "IX", "LVIII", "MCMXCIV","VI"};
    public static int[] exceptedNums = {3, 4, 9, 58, 1994, 6};
//    public static String[] romanStrings = {"III", "I", "II", "IV", "IX", "XL", "XC", "CD", "CM"};
//    public static int[] exceptedNums = {3, 1, 2, 4, 9, 40, 90, 400, 900};

    @Test
    public void romanToInt() {
        int[] actualNums = new int[romanStrings.length];
        for (int i = 0; i < romanStrings.length; i++) {
            String romanString = romanStrings[i];
            actualNums[i] = RomanToIntT013.romanToInt(romanString);
        }
        Assert.assertArrayEquals(exceptedNums, actualNums);
    }

    @Test
    public void romanToIntByMap() {
        int[] actualNums = new int[romanStrings.length];
        for (int i = 0; i < romanStrings.length; i++) {
            String romanString = romanStrings[i];
            actualNums[i] = RomanToIntT013.romanToIntByMap(romanString);
        }
        Assert.assertArrayEquals(exceptedNums, actualNums);
    }
}