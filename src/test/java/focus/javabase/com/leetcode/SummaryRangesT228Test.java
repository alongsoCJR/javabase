package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SummaryRangesT228Test extends AbstractTest {


    //Input: nums = [0,2,3,4,6,8,9]
    //Output: ["0","2->4","6","8->9"]
    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{0, 2, 3, 4, 6, 8, 9};
    }

    @Test
    public void summaryRanges() {
        System.out.println(SummaryRangesT228.summaryRanges1(inputNums));
    }
}