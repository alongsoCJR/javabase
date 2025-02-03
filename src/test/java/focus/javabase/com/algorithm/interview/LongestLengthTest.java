package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.baseTest.Lists;
import focus.javabase.com.leetcode.base.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LongestLengthTest extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputArrayList = Lists.newArrayList(3, 3, 4, 7, 5, 6);
        exceptedNum = 4;
    }


    //    @Before
    public void setUp1() throws Exception {
        inputArrayList = Lists.newArrayList(3, 3, 4, 7, 5, 6, 8, 9, 10, 11, 7, 8);
        exceptedNum = 6;
    }

    @Before
    public void setUp2() throws Exception {
        inputArrayList = Lists.newArrayList(3, 3, 4, 7, 5, 6, 8, 9, 10, 11, 7, 8);
        exceptedArrayList = Lists.newArrayList(1, 2, 4, 5, 10, 11);
    }

    @Test
    public void getLongestLength() {
        Assert.assertEquals(exceptedNum, LongestLength.getLongestLength(inputArrayList));
    }


    @Test
    public void getLongestLength2() {
        Assert.assertEquals(exceptedArrayList, LongestLength.getLongestLength2(inputArrayList));
    }
}