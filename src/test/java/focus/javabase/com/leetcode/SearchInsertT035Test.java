package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchInsertT035Test extends AbstractTest {

            @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 3, 5, 6};
        inputNum = 5;
        exceptedNum = 2;
    }

//            @Before
    public void setUp1() throws Exception {
        inputNums = new int[]{1, 3, 5, 6};
        inputNum = 2;
        exceptedNum = 1;
    }

//    @Before
    public void setUp2() throws Exception {
        inputNums = new int[]{1, 3, 5, 6};
        inputNum = 7;
        exceptedNum = 4;
    }


    //    @Before
    public void setUp3() throws Exception {
        inputNums = new int[]{1, 3, 5, 6};
        inputNum = 0;
        exceptedNum = 0;
    }

    //    @Before
    public void setUp4() throws Exception {
        inputNums = new int[]{1, 2, 4, 6, 7};
        inputNum = 3;
        exceptedNum = 2;
    }


    //info
    //			Wrong Answer:
    //			input:[1,2,4,6,7]
    //			3
    //			Output:1
    //			Expected:2
    @Test
    public void searchInsert() {
        outputNum = SearchInsertT035.searchInsert1(inputNums, inputNum);
        Assert.assertEquals(exceptedNum, outputNum);
    }

    @Test
    public void binarySearch() {
        outputNum = SearchInsertT035.binarySearch(inputNums, 0, inputNums.length - 1, inputNum);
        Assert.assertEquals(exceptedNum, outputNum);
    }
}