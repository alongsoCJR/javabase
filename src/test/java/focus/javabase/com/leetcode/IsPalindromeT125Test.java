package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases.
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome.
//
// Example 1:
//
//
//Input: "A man, a plan, a canal: Panama"
//Output: true
//
//
// Example 2:
//
//
//Input: "race a car"
//Output: false
//
// Related Topics 双指针 字符串


public class IsPalindromeT125Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputStr = "A man, a plan, a canal: Panama";
        exceptedBoolean = true;
    }


    //    @Before
    public void setUp1() throws Exception {
        inputStr = "race a car";
        exceptedBoolean = false;
    }

    //    @Before
    public void setUp2() throws Exception {
        inputStr = ".,";
        exceptedBoolean = true;
    }

    @Before
    public void setUp3() throws Exception {
        inputStr = "0P";
        exceptedBoolean = false;
    }
//info
//			Wrong Answer:
//			input:".,"
//			Output:false
//			Expected:true
//			stdout:


    //info
//			Wrong Answer:
//			input:"0P"
//			Output:true
//			Expected:false
//			stdout:
    @Test
    public void isPalindrome() {
        Assert.assertEquals(exceptedBoolean, IsPalindromeT125.isPalindrome3(inputStr));
    }
}