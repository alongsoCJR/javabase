package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealSomeArrayTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9};
        exceptedNums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    public void dealSomeItem() {
        outputNums = DealSomeArray.dealSomeItem(inputNums);
    }
}