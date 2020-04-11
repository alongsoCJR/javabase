package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignIsValidT020Test extends AbstractTest {

    public static String[] inputStrs = null;

    public static boolean[] exceptedReturns = null;

    @Before
    public void setUp() throws Exception {
        inputStrs = new String[]{"()", "()[]{}", "(]", "([)]", "{[]}", "([]", "{{)}"};
        exceptedReturns = new boolean[]{true, true, false, false, true, false, false};
    }

    @Test
    public void isValid() {
        for (int i = 0; i < exceptedReturns.length; i++) {
            boolean actual = SignIsValidT020.isValid(inputStrs[i]);
            Assert.assertEquals(exceptedReturns[i], actual);
        }
    }
}