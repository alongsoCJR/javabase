package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//A valid parentheses string is either empty (""), "(" + A + ")", or A + B, wher
//e A and B are valid parentheses strings, and + represents string concatenation.
//For example, "", "()", "(())()", and "(()(()))" are all valid parentheses string
//s.
//
// A valid parentheses string S is primitive if it is nonempty, and there does n
//ot exist a way to split it into S = A+B, with A and B nonempty valid parentheses
// strings.
//
// Given a valid parentheses string S, consider its primitive decomposition: S =
// P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
//
// Return S after removing the outermost parentheses of every primitive string i
//n the primitive decomposition of S.
//
//
//
// Example 1:
//
//
//Input: "(()())(())"
//Output: "()()()"
//Explanation:
//The input string is "(()())(())", with primitive decomposition "(()())" + "(()
//)".
//After removing outer parentheses of each part, this is "()()" + "()" = "()()()
//".
//
//
//
// Example 2:
//
//
//Input: "(()())(())(()(()))"
//Output: "()()()()(())"
//Explanation:
//The input string is "(()())(())(()(()))", with primitive decomposition "(()())
//" + "(())" + "(()(()))".
//After removing outer parentheses of each part, this is "()()" + "()" + "()(())
//" = "()()()()(())".
//
//
//
// Example 3:
//
//
//Input: "()()"
//Output: ""
//Explanation:
//The input string is "()()", with primitive decomposition "()" + "()".
//After removing outer parentheses of each part, this is "" + "" = "".
//
//
//
//
//
//
// Note:
//
//
// S.length <= 10000
// S[i] is "(" or ")"
// S is a valid parentheses string
//
//
//
//
//
//
// Related Topics 栈


public class RemoveOuterParenthesesTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputStrs = new String[]{"(()())(())(()(()))", "(()())(())", "()()"};
        exceptedStrs = new String[]{"()()()()(())", "()()()", ""};
    }

    @Test
    public void removeouterparentheses() {
        Assert.assertEquals(exceptedStrs[0], RemoveOuterParentheses.removeouterparentheses(inputStrs[0]));
    }
}