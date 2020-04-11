package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesT026Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 1, 2};
        exceptedNum = 2;
    }
//
//    @Before
//    public void setUp() throws Exception {
//        inputNums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        exceptedNum = 5;
//    }


//    @Before
//    public void setUp() throws Exception {
//        inputNums = new int[]{};
//        exceptedNum = 0;
//    }

    @Test
    public void removeDuplicates() {
        outputNum = RemoveDuplicatesT026.removeDuplicates1(inputNums);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}