package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
//
//请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
//
//返回重新排列后的字符串。
//
public class RestoreStringT1528Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
        inputStr = "codeleet";
        exceptedStr = "leetcode";
    }

    @Test
    public void restoreString() {
        Assert.assertEquals(exceptedStr, RestoreStringT1528.restoreString(inputStr, inputNums));
    }
}