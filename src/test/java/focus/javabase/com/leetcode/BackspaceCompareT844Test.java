package focus.javabase.com.leetcode;

import com.sun.javafx.geom.transform.Affine3D;
import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given two strings S and T, return if they are equal when both are typed into e
//mpty text editors. # means a backspace character.
//
// Note that after backspacing an empty text, the text will continue empty.
//
//
// Example 1:
//
//
//Input: S = "ab#c", T = "ad#c"
//Output: true
//Explanation: Both S and T become "ac".
//
//
//
// Example 2:
//
//
//Input: S = "ab##", T = "c#d#"
//Output: true
//Explanation: Both S and T become "".
//
//
//
// Example 3:
//
//
//Input: S = "a##c", T = "#a#c"
//Output: true
//Explanation: Both S and T become "c".
//
//
//
// Example 4:
//
//
//Input: S = "a#c", T = "b"
//Output: false
//Explanation: S becomes "c" while T becomes "b".
//
//
// Note:
//
//
// 1 <= S.length <= 200
// 1 <= T.length <= 200
// S and T only contain lowercase letters and '#' characters.
//
//
// Follow up:
//
//
// Can you solve it in O(N) time and O(1) space?
//
//
//
//
//
// Related Topics 栈 双指针


public class BackspaceCompareT844Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputStrs = new String[]{"ab#c", "ad#c"};
        exceptedBoolean = true;
    }

    @Test
    public void backspaceCompare() {
        Assert.assertEquals(exceptedBoolean, BackspaceCompareT844.backspaceCompare(inputStrs[0], inputStrs[1]));
    }
}