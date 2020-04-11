package focus.javabase.com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsPalindromeT009Test {

    @Test
    public void isPalindrome() {
        assertEquals(true, IsPalindromeT009.isPalindrome(121));
        assertEquals(false, IsPalindromeT009.isPalindrome(-121));
        assertEquals(false, IsPalindromeT009.isPalindrome(10));
        assertEquals(true, IsPalindromeT009.isPalindrome(1001));
    }


    @Test
    public void isPalindrome1() {
        assertEquals(true, IsPalindromeT009.isPalindrome1(121));
        assertEquals(false, IsPalindromeT009.isPalindrome1(-121));
        assertEquals(false, IsPalindromeT009.isPalindrome1(10));
        assertEquals(true, IsPalindromeT009.isPalindrome1(1001));
    }
}
