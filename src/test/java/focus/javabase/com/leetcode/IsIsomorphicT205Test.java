package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


// Example 1:
// Input: s = "egg", t = "add"
//Output: true
// Example 2:
// Input: s = "foo", t = "bar"
//Output: false
// Example 3:
// Input: s = "paper", t = "title"
//Output: true
public class IsIsomorphicT205Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputStrs = new String[]{"paper", "title"};
//        inputStrs = new String[]{"foo", "bar"};
//        inputStrs = new String[]{"egg", "add"};
        exceptedBoolean = true;
    }

    // info
    //			Wrong Answer:
    //			input:"badc"
    //			"baba"
    //			Output:true
    //			Expected:false
    //			stdout:
    @Before
    public void setUp1() throws Exception {
        inputStrs = new String[]{"badc", "baba"};
        exceptedBoolean = false;
    }

    @Test
    public void isIsomorphic() {
        Assert.assertEquals(exceptedBoolean, IsIsomorphicT205.isIsomorphic2(inputStrs[0], inputStrs[1]));
    }
}